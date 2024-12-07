package ru.javawebinar.basejava.reflectionexample;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionCheker {
    public void showClassName(Object object) throws NoSuchMethodException, SecurityException {
        @SuppressWarnings("rawtypes")
        Class clazz = object.getClass();
        System.out.println(clazz.getName());
        /*for (Constructor constr : clazz.getConstructors()) {
            for (Class param : constr.getParameterTypes()) {
                System.out.println(constr + " = " + param);
            }
        }*/
        //Constructor c1 = clazz.getConstructor(new Class[]{String.class});
        //System.out.println(c1);

        /*Method [] methods = clazz.getMethods();
        for(Method method : methods){
            if(isGetter(method)) System.out.println("getter: " + method);
            if(isSetter(method)) System.out.println("setter: " + method);
        }*/

    }
    
    /*public static boolean isGetter(Method method){
        if (!method.getName().startsWith("get")) {
             return false;
        } 
        if (method.getParameterTypes().length != 0) {
             return false;  
        } 
        if (void.class.equals(method.getReturnType())) {
             return false;
        } 
        return true;
      }
       
      public static boolean isSetter(Method method){
        if (!method.getName().startsWith("set")) {
             return false;
        } 
        if (method.getParameterTypes().length != 1) {
             return false;
        } 
        return true;
      }*/

    public void showClassFields(Object object) {
        @SuppressWarnings("rawtypes")
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            System.out.println("Field: " + field.getName() + " = " + field.getType() + " = " + Modifier.isPublic(field.getModifiers()));
        }
    }

    public void showClassMethods(Object object) {
        @SuppressWarnings("rawtypes")
        Class clazz = object.getClass();
        Method [] methods = clazz.getMethods();
        for(Method method : methods) {
            System.out.println("Method: " + method.getName() + " = " + method.getParameterCount() + " = " + Modifier.isPublic(method.getModifiers()));
        }
    }

    public void showFieldsAnnotations(Object object) {
        @SuppressWarnings("rawtypes")
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            Annotation [] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("Field name: " + field.getName() + " = annotation name: " + annotation);
            }
        }
    }

    public void showClassAnnotations(Object object) {
        @SuppressWarnings("rawtypes")
        Class clazz = object.getClass();
        Annotation [] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof RabbitAnnotation) {
                RabbitAnnotation rabbitAnnotation = (RabbitAnnotation) annotation;
                System.out.println("RabbitAnnotation name: " + rabbitAnnotation.name());
            }
            //System.out.println("Annotation name: " + annotation);
        }

    }

    public void fillPrivateFields(Object object) throws IllegalAccessException {
        @SuppressWarnings("rawtypes")
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
        @SuppressWarnings("rawtypes")
        Class clazz = object.getClass();
        return clazz.newInstance();
    }

    public void getGenericsMethodType(Object object) throws NoSuchMethodException, SecurityException{
        @SuppressWarnings("rawtypes")
        Class clazz = object.getClass();
        Method method = clazz.getMethod("getList", null);

        Type returnType = method.getGenericReturnType();
        System.out.println("returnType: " + returnType);

        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                @SuppressWarnings("rawtypes")
                Class typeClass = (Class) typeArgument;
                System.out.println("Type: " + typeClass);
            }
        }
    }

    public void getGenericFieldType(Object object) throws NoSuchFieldException, SecurityException {
        @SuppressWarnings("rawtypes")
        Class clazz = object.getClass();
        Field field = clazz.getDeclaredField("simpleList");

        Type genericFieldType = field.getGenericType();
        System.out.println("genericFieldType: " + genericFieldType);

        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = pType.getActualTypeArguments();
            for (Type fieldArgType : fieldArgTypes){
                @SuppressWarnings("rawtypes")
                Class fieldClass = (Class) fieldArgType;
                System.out.println("Type: " + fieldClass);
            }
        }
    }
}
