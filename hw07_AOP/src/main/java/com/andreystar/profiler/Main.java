package com.andreystar.profiler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, IOException {
        if (args == null || args.length < 2 || args[0] == null || args[1] == null) {
            System.out.println("Usage: <package> <main-class> [--tree]");
            return;
        }
        System.setProperty("profiledPackage", args[0]);
        Class<?> cls = Class.forName(args[1]);
        Method m = cls.getMethod("main", String[].class);
        m.invoke(null, (Object) null);

        Call init = Profiler.getInstance().getInitCall();
        CallTreeAnalyzer cta = new CallTreeAnalyzer(init);
        cta.printStats();
        if (args.length >= 3 && args[2].equals("--tree")) {
            cta.printTree();
            cta.generateImage(Path.of("src/main/resources/"), cls.getSimpleName());
        }
    }

}
