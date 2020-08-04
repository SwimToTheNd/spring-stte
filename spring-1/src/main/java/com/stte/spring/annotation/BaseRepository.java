package com.stte.spring.annotation;

/**
 * create by BloodFly at 2020/6/25
 */
public class BaseRepository<T> {

    public void save(T t) {
        System.out.println("save: " + t);
        System.out.println(this);
    }
}
