package com.library.spring_boot_library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "checkout_date")
    private String checkoutDate;

    @Column(name = "returned_date")
    private String returnedDate;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "img")
    private String img;

    public History(){}

    public History(String userEmail,
                   String checkoutDate,
                   String returnedDate,
                   String title,
                   String author,
                   String description,
                   String img) {
        this.userEmail = userEmail;
        this.checkoutDate = checkoutDate;
        this.returnedDate = returnedDate;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public History setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public History setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public History setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
        return this;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public History setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public History setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public History setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public History setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImg() {
        return img;
    }

    public History setImg(String img) {
        this.img = img;
        return this;
    }
}
