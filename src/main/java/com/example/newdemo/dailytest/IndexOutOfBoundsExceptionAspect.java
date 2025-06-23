package com.example.newdemo.dailytest;

import cn.hutool.core.collection.CollUtil;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class IndexOutOfBoundsExceptionAspect {

    /**
     * 处理索引超界异常的切面方法
     * 当任何方法抛出IndexOutOfBoundsException时，该方法将被调用
     *
     * @param ex 抛出的索引超界异常实例
     */
    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "ex")
    public void handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
        // 处理索引超界异常的逻辑
        System.out.println("捕获到索引超界异常: " + ex.getMessage());
        ArrayList<String> strList = CollUtil.toList("1", "2", "3", "4");
        strList.forEach(item -> System.out.println(item));
        List<List<String>> lists = CollUtil.splitList(strList, 2);
        lists.forEach(item -> System.out.println(item));
        lists.forEach(item -> item.forEach(item1 -> System.out.println(item1)));

        // 这里可以添加更多的日志记录、错误报告等操作

    }
}
    