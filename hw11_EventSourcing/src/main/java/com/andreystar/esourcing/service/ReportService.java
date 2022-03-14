package com.andreystar.esourcing.service;

import com.andreystar.esourcing.event.Direction;
import com.andreystar.esourcing.event.TurnstileEvent;
import com.andreystar.esourcing.query.AverageStatistics;
import com.andreystar.esourcing.repository.TurnstileEventRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final TurnstileEventRepository turnstileEventRepository;

    private long visits = 0;
    private long secondsSpent = 0;
    private LocalDateTime lastSnapshot = LocalDateTime.MIN;
    private LocalDateTime firstDay = null;

    public ReportService(TurnstileEventRepository turnstileEventRepository) {
        this.turnstileEventRepository = turnstileEventRepository;
    }

    public Map<LocalDateTime, Integer> getDayStatistics(int daysBack) {
        LocalDateTime now = LocalDateTime.now();
        List<LocalDateTime> dates = turnstileEventRepository.findAll()
                                                            .stream()
                                                            .filter(t -> t.getDirection() == Direction.IN
                                                                    && t.getCreated().isAfter(now.minusDays(daysBack)))
                                                            .map(TurnstileEvent::getCreated)
                                                            .map(t -> t.withNano(0)
                                                                       .withSecond(0)
                                                                       .withMinute(0)
                                                                       .withHour(0))
                                                            .collect(Collectors.toList());

        Map<LocalDateTime, Integer> res = new HashMap<>();
        for (LocalDateTime date : dates) {
            res.put(date, res.getOrDefault(date, 0) + 1);
        }
        return res;
    }

    public AverageStatistics averageStatistics() {
        if (firstDay == null) {
            Optional<LocalDateTime> min = turnstileEventRepository.findAll()
                                                                  .stream()
                                                                  .map(TurnstileEvent::getCreated)
                                                                  .min(LocalDateTime::compareTo);
            if (min.isEmpty()) {
                return new AverageStatistics(0, 0);
            }
            firstDay = min.get();
        }
        LocalDateTime now = LocalDateTime.now();
        visits += turnstileEventRepository.findAll()
                                          .stream()
                                          .filter(t -> t.getDirection() == Direction.IN
                                                  && t.getCreated().isAfter(lastSnapshot)
                                                  && t.getCreated().isBefore(now))
                                          .count();
        secondsSpent += turnstileEventRepository.findAll()
                                                .stream()
                                                .filter(t -> t.getDirection() == Direction.OUT
                                                        && t.getCreated().isAfter(lastSnapshot)
                                                        && t.getCreated().isBefore(now))
                                                .map(TurnstileEvent::getCreated)
                                                .mapToLong(l -> l.toEpochSecond(ZoneOffset.UTC))
                                                .sum();
        secondsSpent -= turnstileEventRepository.findAll()
                                                .stream()
                                                .filter(t -> t.getDirection() == Direction.IN
                                                        && t.getCreated().isAfter(lastSnapshot)
                                                        && t.getCreated().isBefore(now))
                                                .map(TurnstileEvent::getCreated)
                                                .mapToLong(l -> l.toEpochSecond(ZoneOffset.UTC))
                                                .sum();
        lastSnapshot = now;
        long days = Duration.between(firstDay, now).toDays();
        return new AverageStatistics(1.0 * visits / days, 1.0 * secondsSpent / visits / 60);
    }
}
