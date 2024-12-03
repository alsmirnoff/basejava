package ru.javawebinar.basejava.functionalInterfaces;

@FunctionalInterface
public interface IntElementGenerator {
    public Integer next(Integer current);
}
