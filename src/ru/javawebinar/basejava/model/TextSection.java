package ru.javawebinar.basejava.model;

import java.util.Objects;

public class TextSection extends Section {
    
    private final String content;

    public TextSection(String content) {
        Objects.requireNonNull(content, "content must not be null");
        this.content = content;
    }

    public String getContent() { return content; }

    public String toString() { return content; }

    @Override
    public int hashCode() { return content.hashCode(); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TextSection other = (TextSection) obj;
        return content.equals(other.content); 
    }
    
}
