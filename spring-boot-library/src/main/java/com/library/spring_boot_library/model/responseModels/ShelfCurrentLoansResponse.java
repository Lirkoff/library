package com.library.spring_boot_library.model.responseModels;

import com.library.spring_boot_library.model.entity.Book;


public record ShelfCurrentLoansResponse(Book book, int daysLeft) {
}
