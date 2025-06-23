package com.example.newdemo.aspect;

import com.example.newdemo.cache.SimpleCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheAspect {

    @Autowired
    private CacheManager cacheManager;

    @Around("@annotation(simpleCache)")
    public Object cacheAroundAdvice(ProceedingJoinPoint joinPoint, SimpleCache simpleCache) throws Throwable {
        String cacheName = simpleCache.value().isEmpty() ? "defaultCache" : simpleCache.value();
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            String key = generateKey(joinPoint);
            Cache.ValueWrapper cachedValue = cache.get(key);
            if (cachedValue != null) {
                return cachedValue.get();
            }
            Object result = joinPoint.proceed();
            cache.put(key, result);
            return result;
        } else {
            return joinPoint.proceed();
        }
    }

    private String generateKey(ProceedingJoinPoint joinPoint) {
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(joinPoint.getSignature().toShortString());
        for (Object arg : joinPoint.getArgs()) {
            keyBuilder.append(arg.toString());
        }
        return keyBuilder.toString();
    }
}
