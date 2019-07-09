package ru.aoklimov.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) {
        Class<Arrays> arraysClass = Arrays.class;

        System.out.println(arraysClass.getTypeName());
        System.out.println("Fields of " + arraysClass.getName());

        for (Field field : arraysClass.getFields()) {
            System.out.println("\t" + field);
        }

        System.out.println("Methods of " + arraysClass.getName());

        for (Method method : arraysClass.getMethods()) {
            System.out.println("\t" + method);
        }
    }
}
