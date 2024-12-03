package com.library.spring_boot_library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "checkout_date")
    private String checkoutDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "book_id")
    private Long bookId;

    public Checkout() {
    }

    public Checkout(String userEmail, String checkoutDate, String returnDate, Long bookId) {
        this.userEmail = userEmail;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
        this.bookId = bookId;
    }

    public Long getId() {
        return id;
    }

    public Checkout setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Checkout setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public Checkout setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
        return this;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public Checkout setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public Long getBookId() {
        return bookId;
    }

    public Checkout setBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }
}
