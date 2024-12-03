package ru.javawebinar.basejava.functionalInterfaces;

@FunctionalInterface
public interface Generator {
    // public int getNextElement();
    // public int getNextElement(IntGenerator gen);
    // public Object createNewObject();
    public Object createNewObject(int size);
}
