package com.library.spring_boot_library.model.requestModels;

import java.util.Optional;

public class ReviewRequest {
    private double rating;

    private Long bookId;

    private Optional<String> reviewDescription;

    public double getRating() {
        return rating;
    }

    public ReviewRequest setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public Long getBookId() {
        return bookId;
    }

    public ReviewRequest setBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    public Optional<String> getReviewDescription() {
        return reviewDescription;
    }

    public ReviewRequest setReviewDescription(Optional<String> reviewDescription) {
        this.reviewDescription = reviewDescription;
        return this;
    }
}
