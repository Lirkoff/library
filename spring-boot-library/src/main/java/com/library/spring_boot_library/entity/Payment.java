package com.library.spring_boot_library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "amount")
    private double amount;

    public Long getId() {
        return id;
    }

    public Payment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Payment setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Payment setAmount(double amount) {
        this.amount = amount;
        return this;
    }
}
