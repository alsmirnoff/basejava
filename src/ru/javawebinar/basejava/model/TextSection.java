package ru.javawebinar.basejava.model;

public class TextSection extends Section {
    
    private String content;

    public String getContent(){
        return content;
    }

    public TextSection(String content){
        this.content = content;
    }

    public String toString(){
        return content;
    }
}
