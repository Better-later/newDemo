package com.example.newdemo.dailytest;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public void testMethod() {
        // 模拟抛出 IndexOutOfBoundsException
        int[] array = new int[5];
        System.out.println(array[10]); // 这里会抛出 IndexOutOfBoundsException
    }
}
