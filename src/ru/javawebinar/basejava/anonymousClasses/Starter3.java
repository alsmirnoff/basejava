package ru.javawebinar.basejava.anonymousClasses;

public class Starter3 {
    public static void main(String[] args) {
        final IPrinter printer = new IPrinter() {

            @Override
            public void printText() {
                System.out.println("text to print");
            }
        };
        printer.printText();
    }
}
