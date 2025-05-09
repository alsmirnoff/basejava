package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Resume r = new Resume("name");
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        /*Method [] methods = resumeClass.getMethods();
        for (Method method : methods) {
            System.out.println("method name: " + method.getName() );
        }*/
        
        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(r);
        System.out.println("toString invoke: " + result);
    }
}
