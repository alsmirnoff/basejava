package ru.javawebinar.basejava.model;

import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {
    
    private final String name;
    
    private final String url;

    public Link(String name, String url) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        this.url = url;
    }

    public String getName() { return name; }

    public String getUrl() { return url; }

    @Override
    public String toString() {
        return "Link (" + name + "," + url + ")";
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + ((url != null) ?  url.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Link other = (Link) obj;
        if (!name.equals(other.name)) return false;
        return url != null ? url.equals(other.url) : other.url == null;
    }

    
    
}
