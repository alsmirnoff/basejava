package ru.javawebinar.basejava.junitexample;

public class MathFunc {
    public static int add(int a, int b) throws InterruptedException {
        Thread.sleep(200);
        return a+b;
    }
    public static int div(int a, int b) throws InterruptedException {
        Thread.sleep(200);
        return a/b;
    }
}