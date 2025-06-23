package com.example.newdemo.service;

// ClassA.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassA {
//    @Autowired
//    private ClassB classB;

//    @Autowired
//    public void setClassB(ClassB classB) {
//        this.classB = classB;
//    }

    public void doSomething() {
        System.out.println("this is classA");
//        classB.doSomethingElse();
    }
}

