package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

public class Organization {

    private String homePage;

    private Collection<Period> period;

    private LocalDate startDate;

    private LocalDate endDate;

    private String title;
    
    private String description;

    public Organization(String title, LocalDate startDate, LocalDate endDate){
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setPeriod(Collection<Period> period){
        this.period = period;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public Collection<Period> getPeriod() {
        return period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return "В " + title + " c " + startDate + " по " + endDate;
    }
}
