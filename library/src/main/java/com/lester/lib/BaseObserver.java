package com.lester.lib;

import com.lester.lib.core.Observer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseObserver<T> implements Observer {

    public  T transfer(String str) {

        Object obj = new Object();



        return (T)obj;
    };

    private Class<?> getClass(Object obj) {
        Class<?> clazz = null;

        Type genType = obj.getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType)genType).getActualTypeArguments();

        clazz = (Class<?>) types[0];

        return clazz;
    }


}
