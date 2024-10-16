package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        Class clazz = r.getClass();
        /*Method [] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("method name: " + method.getName() );
        }*/
        
        Method method = clazz.getMethod("toString");
        System.out.println("toString invoke: " + method.invoke(r));

        // TODO : invoke r.toString via Reflection
        System.out.println(r);
    }
}
