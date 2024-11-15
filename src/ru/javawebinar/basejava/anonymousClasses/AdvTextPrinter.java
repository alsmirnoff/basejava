package ru.javawebinar.basejava.anonymousClasses;

public class AdvTextPrinter extends TextPrinter {
    
    public AdvTextPrinter(final String text) {
        super(text);
    }

    @Override
    public void printText() {
        System.out.println("******");
        super.printText();
    }

}
