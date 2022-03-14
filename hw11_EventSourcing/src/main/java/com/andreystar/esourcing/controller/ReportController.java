package com.andreystar.esourcing.controller;

import com.andreystar.esourcing.query.AverageStatistics;
import com.andreystar.esourcing.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/days")
    public Map<LocalDateTime, Integer> getDayStatistics(@RequestParam int daysBack) {
        return reportService.getDayStatistics(daysBack);
    }

    @GetMapping("/average")
    public AverageStatistics averageStatistics() {
        return reportService.averageStatistics();
    }

}
