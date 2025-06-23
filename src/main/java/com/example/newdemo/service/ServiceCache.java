package com.example.newdemo.service;

import com.example.newdemo.cache.SimpleCache;
import org.springframework.stereotype.Service;

@Service
public class ServiceCache {
    @SimpleCache
    public String getCachedData(String param) {
        // 模拟耗时操作，例如操作数据库
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Cached Data for " + param;
    }
}
