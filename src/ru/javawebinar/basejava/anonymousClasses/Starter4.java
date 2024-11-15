package ru.javawebinar.basejava.anonymousClasses;

public class Starter4 {
    public static void main(String[] args) {
        String text = args[0];
        final IPrinter printer = new IPrinter() {
            @Override
            public void printText() {
                System.out.println(text);
            }
        };
        printer.printText();
    }
}
