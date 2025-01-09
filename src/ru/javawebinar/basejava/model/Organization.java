package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {

    private final Link homePage;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final String title;
    
    private final String description;

    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description){
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.homePage = new Link(name, url);
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    

    @Override
    public String toString() {
        return "Organization {" +
                "homePage=" + homePage + 
                ", startDate=" + startDate + 
                ", endDate=" + endDate + 
                ", title=" + title + '\'' + 
                ", description=" + description + '\'' + 
                "}";
    }



    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + ((description != null) ? description.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Organization other = (Organization) obj;
        if (!homePage.equals(other.homePage)) return false;
        if (!startDate.equals(other.startDate)) return false;
        if (!endDate.equals(other.endDate)) return false;
        if (!title.equals(other.title)) return false;
        return description != null ? description.equals(other.description) : other.description == null; 
    }

    
    
}
