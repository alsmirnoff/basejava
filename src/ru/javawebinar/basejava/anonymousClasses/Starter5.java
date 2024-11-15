package ru.javawebinar.basejava.anonymousClasses;

public class Starter5 {

    private String text;
    public static void main(String[] args) {
        Starter5 starter5 = new Starter5();
        starter5.text = "11";
        starter5.m();
    }
    
    public void m() {
        final IPrinter printer = new IPrinter() {
            @Override
            public void printText() {
                System.out.println(text);
            }
        };
        printer.printText();
        //text = "12";
    }
}