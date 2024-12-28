package com.library.spring_boot_library.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @Column(name = "rating")
    private double rating;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "review_description")
    private String reviewDescription;

    public Long getId() {
        return id;
    }

    public Review setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Review setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Review setDate(Date date) {
        this.date = date;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Review setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public Long getBookId() {
        return bookId;
    }

    public Review setBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public Review setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
        return this;
    }
}
