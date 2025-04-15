package ru.javawebinar.basejava.model;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Link implements Serializable {
    
    private String name;
    
    private String url;

    public Link() {}

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
