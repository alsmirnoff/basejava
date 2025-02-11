package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
    
    private final List<String> items;

    public ListSection(String... items) { this(Arrays.asList(items)); }

    public ListSection(List<String> items){
        Objects.requireNonNull(items, "items must not be null");
        this.items = items;
    }

    public List<String> getItems() { return items; }

    @Override
    public String toString() { return items.toString(); }

    @Override
    public int hashCode() { return items.hashCode(); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ListSection other = (ListSection) obj;
        return items.equals(other.items); 
    }

}
