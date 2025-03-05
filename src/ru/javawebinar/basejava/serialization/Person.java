package ru.javawebinar.basejava.serialization;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 700671495380379912L;

    private int id;
    private String personName;
    private int age;
    private byte type;

    public Person(int id, String name) {
        this.id = id;
        this.personName = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return personName;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + personName + "]";
    }
    
}
