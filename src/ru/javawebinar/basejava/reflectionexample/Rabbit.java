package ru.javawebinar.basejava.reflectionexample;

public class Rabbit {
    
    @Deprecated
    @RabbitAnnotation
    private String rabbitName;

    @Deprecated
    //@RabbitAnnotation
    public int rabbitAge;

    //@RabbitAnnotation
    protected double rabbitHeight;
    
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
