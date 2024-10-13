package ru.javawebinar.basejava.reflectionexample;

public class ReflectionExample {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, NoSuchFieldException {
        ReflectionCheker cheker = new ReflectionCheker();
        Rabbit rabbit = new Rabbit();
        SimpleClass simpleClass = new SimpleClass();

        //cheker.showClassMethods(simpleClass);
        //cheker.getGenericsMethodType(simpleClass);
        cheker.getGenericFieldType(simpleClass);

        //cheker.showClassFields(simpleClass);

        //cheker.showClassName(rabbit);
        //cheker.showClassFields(rabbit);
        //cheker.showClassMethods(cheker);

        //cheker.showFieldsAnnotations(rabbit);

        //cheker.showClassAnnotations(rabbit);

        //cheker.fillPrivateFields(rabbit);

        /*Object clone = cheker.createNewObject(rabbit);

        cheker.showClassName(clone);*/

        /*System.out.println(rabbit.getRabbitName());
        System.out.println(rabbit.getRabbitAge());
        System.out.println(rabbit.getRabbitHeight());*/
    }
}
