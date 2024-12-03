package ru.javawebinar.basejava.functionalInterfaces;

public class NumberGenerator {
    public Integer add(Integer n) {
        return n + 10;
    }

    public Double add(Double n) {
        return n + 10.0;
    }

    public String add(String n) {
        return n + " " + n;
    }
}
