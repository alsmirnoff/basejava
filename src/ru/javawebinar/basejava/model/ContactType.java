package ru.javawebinar.basejava.model;

public enum ContactType {
    PHONE("Тел."),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел."),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private final String type;

    ContactType(String type) { 
        this.type = type; 
    }

    public String getType() { 
        return type; 
    }
}
