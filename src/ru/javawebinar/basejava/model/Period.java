package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class Period {

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final String title;
    
    private final String description;

    public Period(LocalDate startDate, LocalDate endDate, String title, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "startDate=" + startDate + 
                ", endDate=" + endDate + 
                ", title=" + title + '\'' + 
                ", description=" + description + '\'' + 
                "}";
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + ((description != null) ? description.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Period other = (Period) obj;
        if (!startDate.equals(other.startDate)) return false;
        if (!endDate.equals(other.endDate)) return false;
        if (!title.equals(other.title)) return false;
        return description != null ? description.equals(other.description) : other.description == null; 
    }


}
