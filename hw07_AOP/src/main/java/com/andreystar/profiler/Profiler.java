package com.andreystar.profiler;

import java.util.ArrayDeque;
import java.util.Deque;

public class Profiler {

    private static Profiler instance;
    private static Call init;

    public static Profiler getInstance() {
        if (instance == null) {
            instance = new Profiler();
        }
        return instance;
    }

    private Profiler() {
    }

    private final Deque<Call> stack = new ArrayDeque<>();

    public void started(String name) {
        Call method = new Call(name, System.nanoTime());
        if (stack.isEmpty()) {
            init = method;
        }
        stack.push(method);
    }

    public void finished() {
        Call method = stack.pop();
        method.setFinished(System.nanoTime());
        if (!stack.isEmpty()) {
            stack.peek().subCalls.add(method);
        }
    }

    public Call getInitCall() {
        return init;
    }

}
