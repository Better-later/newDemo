package com.example.newdemo.bean;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class MyEntity {
    private int id;
    private String name;
    private BigDecimal amount;

    public MyEntity(int id, String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

