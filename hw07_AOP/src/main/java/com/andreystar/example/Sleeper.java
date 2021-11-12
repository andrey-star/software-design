package com.andreystar.example;

import com.andreystar.example.inner.InnerSleep;

public class Sleeper {
    public void sleep1() throws InterruptedException {
        Thread.sleep(100);
    }

    public void sleep2() throws InterruptedException {
        Thread.sleep(200);
    }

    public void sleep3() throws InterruptedException {
        Thread.sleep(300);
    }

    public void innerSleep() throws InterruptedException {
        new InnerSleep().sleep();
    }
}
