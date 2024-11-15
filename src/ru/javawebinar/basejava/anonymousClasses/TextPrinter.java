package ru.javawebinar.basejava.anonymousClasses;

public class TextPrinter implements IPrinter{

    private String text;

    public TextPrinter(String text){
        this.text = text;
    };

    @Override
    public void printText() {
        System.out.println(text);
    }

    public String getText(){
        return text;
    }

}
