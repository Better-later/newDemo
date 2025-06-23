package com.example.newdemo;

import lombok.Data;

@Data
public class Person {
    int age;
    String name;

    public Person(){}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
