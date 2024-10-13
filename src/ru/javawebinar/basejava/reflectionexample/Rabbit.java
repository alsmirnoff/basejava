package ru.javawebinar.basejava.reflectionexample;

@RabbitAnnotation(name = "test name")
public class Rabbit {
    
    @Deprecated
    //@RabbitAnnotation
    private String rabbitName;

    @Deprecated
    //@RabbitAnnotation
    public int rabbitAge;

    //@RabbitAnnotation
    protected double rabbitHeight;

    public Rabbit() {}

    public Rabbit(String name) {
        this.rabbitName = name;
    }
    
    public String getRabbitName() {
        return rabbitName;
    }
    public int getRabbitAge() {
        return rabbitAge;
    }
    public double getRabbitHeight() {
        return rabbitHeight;
    }
}
