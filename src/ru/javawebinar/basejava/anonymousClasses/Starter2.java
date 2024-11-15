package ru.javawebinar.basejava.anonymousClasses;

public class Starter2 {
    public static void main (final String[] args) {
      final IPrinter textPrinter = new TextPrinter("text to print") {
        @Override
        public void printText() {
            System.out.println("******");
            super.printText();
        }
      };
      textPrinter.printText(); 
    }
 }