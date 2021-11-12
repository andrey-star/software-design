package com.andreystar.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        run();
    }

    private static void run() throws InterruptedException {
        Sleeper sleeper = new Sleeper();
        sleeper.sleep1();
        sleeper.sleep2();
        sleeper.sleep3();
        sleeper.innerSleep();
    }
}
