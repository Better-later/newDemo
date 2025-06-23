// ClassB.java
package com.example.newdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClassB {
    @Autowired
    private ClassA classA;

    @Value("${backUpPath}")
    private String backUpPath;

//    @Autowired
//    public void setClassA(ClassA classA) {
//        this.classA = classA;
//    }

    public void doSomethingElse() {
        System.out.println("backUpPath:" + backUpPath);
        System.out.println("this is classB");
        classA.doSomething();
    }
}
