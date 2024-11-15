package ru.javawebinar.basejava.anonymousClasses;

public class Starter {
    public static void main(String[] args) {
        final IPrinter textPrinter = new TextPrinter("text to print");
        textPrinter.printText();
        final IPrinter advTextPrinter = new AdvTextPrinter("text to print");
        advTextPrinter.printText();
    }
}
