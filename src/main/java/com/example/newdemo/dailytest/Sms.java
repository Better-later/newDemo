package com.example.newdemo.dailytest;

public class Sms implements Message{
    @Override
    public String send(String name, String date) {
        System.out.println("This is a sms");
        return "";
    }
}
