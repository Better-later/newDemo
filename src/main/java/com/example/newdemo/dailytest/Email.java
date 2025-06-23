package com.example.newdemo.dailytest;

public class Email implements Message{
    @Override
    public String send(String name, String date) {
        System.out.println("This is an email");
        return null;
    }
}
