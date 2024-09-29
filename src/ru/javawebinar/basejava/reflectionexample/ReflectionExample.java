package ru.javawebinar.basejava.reflectionexample;

public class ReflectionExample {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ReflectionCheker cheker = new ReflectionCheker();
        Rabbit rabbit = new Rabbit();

        cheker.showClassName(rabbit);
        /*cheker.showClassFields(rabbit);
        cheker.showClassMethods(cheker);*/

        //cheker.showFieldsAnnotations(rabbit);

        //cheker.fillPrivateFields(rabbit);

        /*Object clone = cheker.createNewObject(rabbit);

        cheker.showClassName(clone);*/

        /*System.out.println(rabbit.getRabbitName());
        System.out.println(rabbit.getRabbitAge());
        System.out.println(rabbit.getRabbitHeight());*/
    }
}
