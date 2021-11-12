package com.andreystar.profiler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Call {
    String name;
    List<Call> subCalls;
    private final long started;
    private long finished;
    private final String simpleName;

    public Call(String name, long started) {
        this.name = name;
        this.started = started;
        this.subCalls = new ArrayList<>();
        String[] nameSplit = name.split("\\.");
        this.simpleName = nameSplit[nameSplit.length - 2] + "." + nameSplit[nameSplit.length - 1];
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }

    public Duration executionTime() {
        return Duration.ofNanos(finished - started);
    }

    public String getRatio(Duration total) {
        return String.format("%.1f%%", (double) executionTime().toNanos() / total.toNanos() * 100);
    }

    public String getSimpleName() {
        return simpleName;
    }
}
