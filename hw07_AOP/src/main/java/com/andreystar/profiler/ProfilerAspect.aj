package com.andreystar.profiler;

import org.aspectj.lang.Signature;

public aspect ProfilerAspect {

    Profiler profiler = Profiler.getInstance();

    pointcut methodCall(): (call(* *(..)) || call(new(..)))
            && if(thisJoinPointStaticPart.getSignature().getDeclaringType().getPackage().toString()
            .startsWith("package " + System.getProperty("profiledPackage")));

    before(): methodCall() {
        profiler.started(formatSignature(thisJoinPointStaticPart.getSignature()));
    }

    after(): methodCall() {
        profiler.finished();
    }

    private String formatSignature(Signature signature) {
        return "%s.%s".formatted(signature.getDeclaringTypeName(), signature.getName());
    }
}
