package com.library.spring_boot_library.responseModels;

import com.library.spring_boot_library.entity.Book;
import jakarta.persistence.Entity;


public class ShelfCurrentLoansResponse {
    private final Book book;
    private final int daysLeft;

    public ShelfCurrentLoansResponse(Book book, int daysLeft) {
        this.book = book;
        this.daysLeft = daysLeft;
    }


    public Book getBook() {
        return book;
    }

    public int getDaysLeft() {
        return daysLeft;
    }
}
