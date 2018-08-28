package com.pramod.manager;

public class GenericClass<T> {

    public static <T>GenericClass<T> newInstance(Class<T> clazz){
        return new GenericClass<T>(clazz);
    }

    private GenericClass(Class<T> clazz){
        System.out.println("please mention some class name");
    }
}