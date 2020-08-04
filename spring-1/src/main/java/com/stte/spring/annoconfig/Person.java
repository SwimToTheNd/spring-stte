package com.stte.spring.annoconfig;

import org.springframework.beans.factory.annotation.Value;

/**
 * create by BloodFly at 2020/7/29
 */
public class Person {

    /**
     * 使用@Value注解给属性设置
     * 可以的写法有：1. 基本的数值
     * 2. SpEL表达式 #{}
     * 3. SpEl表达式 ${}
     */
    @Value("张三")
    private String name;
    @Value("#{20-1}")
    private int age;
    /**
     * 使用${}和@PropertySource读取外部文件K/V值
     */
    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
