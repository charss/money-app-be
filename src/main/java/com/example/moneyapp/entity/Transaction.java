package com.example.moneyapp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {
    private Double amount;
    private String type;
    @ManyToOne
    @JoinColumn(name="account_id")
    @JsonBackReference(value = "transaction-account")
    private Account account;
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonBackReference(value = "transaction-category")
    private Category category;

    @CreatedDate
    @Column(name = "transaction_date", nullable = false, updatable = true)
    private Date transactionDate;

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

    public Account getAccount() {
        return account;
    }

    public Transaction setAccount(Account account) {
        this.account = account;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", type='" + type + '\'' +
                ", account=" + account +
                ", category=" + category +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
