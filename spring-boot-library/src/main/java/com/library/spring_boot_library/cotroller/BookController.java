package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.entity.Book;
import com.library.spring_boot_library.service.BookService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestParam Long bookId) throws Exception {
        String userEmail = "testuser@email.com";

        return bookService.checkoutBook(userEmail, bookId);
    }
}
