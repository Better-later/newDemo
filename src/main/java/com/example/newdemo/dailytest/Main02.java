package com.example.newdemo.dailytest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class Main02 {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal(1).setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal.toString());


        Email email = new Email();
        int a = 2;
        int[] arr = new int[1];


//        System.out.println(arr[0]);
//        sendMessage(new Message() {
//            @Override
//            public void send(int i) {
//                arr[0]++;
//                System.out.println(arr[0]); //1
//                System.out.println(i);//2
//            }
//        },a);
        sendMessage((name,ss) -> {
            System.out.println("this is a lambda test:" + name+",batchDate:"+ss);
            return "success!";
        });

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // 使用 Lambda 表达式遍历列表
        names.forEach(name -> System.out.println(name));




    }


    static void sendMessage(Message message) {
        String status = message.send("qianjin", "20241212");
        System.out.println(status);

    }



}
