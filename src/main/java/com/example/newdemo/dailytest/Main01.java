package com.example.newdemo.dailytest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main01 {

    public static void main(String[] args) {
        String filename = "loan_risk_base-20241204";
        String[] split = filename.split("-");
//        System.out.println(split.length);
//        System.out.println(split[0]);
//        System.out.println(split[1]);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        words.forEach((item) -> System.out.println(item));
        List<String> apple = words.stream().filter(item -> item.equals("apple")).collect(Collectors.toList());
        System.out.println("apple"+apple);

        // 使用Lambda表达式进行排序
        words.sort((a, b) -> {
//            System.out.println("a:"+a);
//            System.out.println("b:"+b);
//            return 1;
            return a.length() - b.length();
        });  // 比较两个字符串的长度

        System.out.println(words);
        int a = 1;
        System.out.println(a);

    }
}
