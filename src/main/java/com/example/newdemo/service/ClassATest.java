package com.example.newdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClassATest {

//    @Autowired
//    private ClassA classA;

//    @Autowired
//    private ClassB classB;

    @Test
    public void testCircularReference() {
//        assertNotNull(classA);
//        assertNotNull(classB);
//        assertNotNull(classA.getClassB());
//        assertNotNull(classB.getClassA());
    }

    @Test
    public void testMethodInvocation() {
        System.out.println("sldkfjsljf");
//        classA.doSomething(); // This should not throw any exceptions
    }
}
