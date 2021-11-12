package com.andreystar.profiler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CallTreeAnalyzer {

    private final Call init;

    public CallTreeAnalyzer(Call init) {
        this.init = init;
    }

    private int index = -1;

    private String getGvGraph() {
        index = -1;
        StringBuilder sb = new StringBuilder("digraph G {\n");
        traverseGV(init, -1, sb);
        sb.append("}\n");
        return sb.toString();
    }

    private void traverseGV(Call t, int pIndex, StringBuilder sb) {
        index++;
        sb.append(String.format("\t%d [label = \"%s%n%d μs%n%s\"]\n",
                index,
                t.getSimpleName(),
                t.executionTime().toNanos() / 1000,
                t.getRatio(init.executionTime())));
        if (pIndex != -1) {
            sb.append(String.format("\t%d -> %d\n", pIndex, index));
        }
        int p = index;
        for (Call ch : t.subCalls) {
            traverseGV(ch, p, sb);
        }
    }

    public void generateImage(Path dest, String fileName) throws IOException {
        try (BufferedWriter out = Files.newBufferedWriter(dest.resolve(fileName + ".dot"))) {
            out.write(getGvGraph());
        }
        Process gen = Runtime.getRuntime()
                             .exec("dot -Tpdf %1$s/%2$s.dot -o %1$s/%2$s.pdf".formatted(dest.toString(), fileName));
        try {
            gen.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printTree() {
        StringBuilder sb = new StringBuilder();
        traverseTree(init, 0, sb);
        System.out.println(sb);
    }

    private void traverseTree(Call t, int depth, StringBuilder sb) {
        sb.append("  ".repeat(depth))
          .append(t.getSimpleName())
          .append(" ")
          .append(t.getRatio(init.executionTime()))
          .append("\n");
        for (Call subCall : t.subCalls) {
            traverseTree(subCall, depth + 1, sb);
        }
    }

    public void printStats() {
        Map<String, MethodStats> stats = new HashMap<>();
        traverseStats(init, stats);
        int longestName = Math.max(stats.values()
                                        .stream()
                                        .map(MethodStats::getName)
                                        .max(Comparator.comparing(String::length))
                                        .map(String::length)
                                        .orElse(0), "Method".length());
        String statsHeader = "| %sMethod |         Total |       Average |".formatted(" ".repeat(longestName - "Method".length()));
        System.out.println("_".repeat(statsHeader.length()));
        System.out.println(statsHeader);
        System.out.println("_".repeat(statsHeader.length()));
        stats.entrySet()
             .stream()
             .sorted(Map.Entry.comparingByValue(Comparator.comparing(MethodStats::getTotal).reversed()))
             .forEach(e -> System.out.println(e.getValue().getStats(longestName)));
        System.out.println("_".repeat(statsHeader.length()));
        System.out.println();
    }

    private void traverseStats(Call call, Map<String, MethodStats> stats) {
        stats.putIfAbsent(call.name, new MethodStats(call.getSimpleName()));
        stats.get(call.name).addCall(call);
        for (Call subCall : call.subCalls) {
            traverseStats(subCall, stats);
        }
    }

    private static class MethodStats {

        Duration total;
        final String name;
        int called = 0;

        private MethodStats(String name) {
            this.name = name;
            total = Duration.ZERO;
        }

        public void addCall(Call call) {
            called++;
            total = total.plus(call.executionTime());
        }

        public String getStats(int maxName) {
            return "| %s%s | %10d μs | %10d μs |".formatted(" ".repeat(maxName - name.length()), name, totalMicros(), averageMicros());
        }

        private long averageMicros() {
            return total.dividedBy(called)
                        .toNanos() / 1000;
        }

        private long totalMicros() {
            return total.toNanos() / 1000;
        }

        public String getName() {
            return name;
        }

        public Duration getTotal() {
            return total;
        }
    }
}
