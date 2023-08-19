package com.example.moneyapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    private String name;
    private Integer userId;

    public Account(Integer id, Date createdAt, Date updatedAt, String name, Integer userId) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.userId = userId;
    }

    public Account() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
