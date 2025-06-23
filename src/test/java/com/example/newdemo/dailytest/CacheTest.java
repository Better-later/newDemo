package com.example.newdemo.dailytest;

import com.example.newdemo.service.ServiceCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTest {

    @Autowired
    private ServiceCache serviceCache;

    @Test
    void testIndividualCache() {
        System.out.println(serviceCache.getCachedData("test"));
        // 缓存中获取
        System.out.println(serviceCache.getCachedData("test"));
    }
}
