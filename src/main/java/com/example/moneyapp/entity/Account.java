package com.example.moneyapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    private String name;
    private Integer userId;
    @OneToMany(mappedBy = "account")
    @JsonManagedReference(value = "transaction-account")
    private List<Transaction> transactions;

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Account setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }
}
