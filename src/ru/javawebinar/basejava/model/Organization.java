package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Organization {

    private final Link homePage;

    private final Collection<Period> periods = new ArrayList<>();

    public Organization(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description){
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.homePage = new Link(name, url);
        periods.add(new Period(startDate, endDate, title, description));
        //this.period.add(Period.between(startDate, endDate));
    }

    public void setPeriod(LocalDate startDate, LocalDate endDate, String title, String description) {
        periods.add(new Period(startDate, endDate, title, description));
    }

    public Collection<Period> getPeriods() {
        return this.periods;
    }


    @Override
    public String toString() {
        return "Organization {" +
                "homePage=" + homePage + 
                ", periods=" + periods + 
                "}";
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Organization other = (Organization) obj;
        if (homePage == null) { 
            if (other.homePage != null) return false;
        } else if (!homePage.equals(other.homePage)) return false;
        if (periods == null) {
            if (other.periods != null) return false;
        } else if (!periods.equals(other.periods)) return false;
        return true;
    }

}
