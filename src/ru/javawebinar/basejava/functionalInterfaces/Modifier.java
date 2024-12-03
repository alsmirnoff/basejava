package ru.javawebinar.basejava.functionalInterfaces;

@FunctionalInterface
public interface Modifier<T> {
    public T change(T obj);
}
