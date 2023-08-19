package com.example.moneyapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {
    private Double amount;
    private String type;
    private Integer categoryId;
    private Integer accountId;

    public Transaction(Integer id, Date createdAt, Date updatedAt, Double amount, String type, Integer categoryId, Integer accountId) {
        super(id, createdAt, updatedAt);
        this.amount = amount;
        this.type = type;
        this.categoryId = categoryId;
        this.accountId = accountId;
    }

    public Transaction() { }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
