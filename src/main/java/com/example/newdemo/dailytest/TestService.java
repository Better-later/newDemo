package com.example.newdemo.dailytest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

//@Service
@SpringBootTest
public class TestService {

    @Test
    public void testMethod() {
        // 模拟抛出 IndexOutOfBoundsException
        int[] array = new int[5];
        System.out.println(array[10]); // 这里会抛出 IndexOutOfBoundsException
    }
}
