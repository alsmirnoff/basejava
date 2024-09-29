package ru.javawebinar.basejava.reflectionexample;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionCheker {
    public void showClassName(Object object) {
        Class clazz = object.getClass();
        System.out.println(clazz.getName());
    }

    public void showClassFields(Object object) {
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            System.out.println("Field: " + field.getName() + " = " + field.getType() + " = " + field.getModifiers());
        }
    }

    public void showClassMethods(Object object) {
        Class clazz = object.getClass();
        Method [] methods = clazz.getMethods();
        for(Method method : methods) {
            System.out.println("Method: " + method.getName() + " = " + method.getParameterCount() + " = " + method.getModifiers());
        }
    }

    public void showFieldsAnnotations(Object object) {
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            Annotation [] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("Field name: " + field.getName() + " = annotation name: " + annotation);
            }
        }
    }

    public void fillPrivateFields(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            Annotation annotation = field.getAnnotation(RabbitAnnotation.class);
            if (annotation == null) {
                continue;
            }

            field.setAccessible(true);
            field.set(object, "FieldValue");
            field.setAccessible(false);
        }
    }

    public Object createNewObject(Object object) throws InstantiationException, IllegalAccessException {
        Class clazz = object.getClass();
        return clazz.newInstance();
    }
}
