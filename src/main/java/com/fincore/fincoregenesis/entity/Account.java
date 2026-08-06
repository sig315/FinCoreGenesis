package com.fincore.fincoregenesis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "口座番号を入力してください")
    @Size(max = 20, message = "口座番号は20文字以内で入力してください")
    @Column(nullable = false, length = 20)
    private String accountNumber;

    @NotBlank(message = "口座名義を入力してください")
    @Size(max = 50, message = "口座名義は50文字以内で入力してください")
    @Column(nullable = false, length = 50)
    private String accountName;

    @NotNull(message = "残高を入力してください")
    @DecimalMin(value = "0", message = "残高は0以上で入力してください")
    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Account(String accountNumber, String accountName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public Account() {
    }
}