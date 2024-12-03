package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.entity.Book;
import com.library.spring_boot_library.service.BookService;
import com.library.spring_boot_library.utils.JwtUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/books")
//@PreAuthorize("hasRole('ROLE_MODERATOR')")
public class BookController {
    private final BookService bookService;
    private final JwtUtils jwtUtils;

    public BookController(BookService bookService, JwtUtils jwtUtils) {
        this.bookService = bookService;
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount() {
        String userEmail = "testuser@email.com";

        return bookService.currentLoansCount(userEmail);
    }

    @GetMapping("/secure/ischeckedout/byuser/")
    public Boolean checkoutBookByUser(@RequestParam Long bookId) throws Exception {
        String userEmail = "testuser@email.com";

        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @PutMapping("/secure/checkout/")
    public Book checkoutBook(@RequestParam Long bookId) throws Exception {
        String userEmail = "testuser@email.com";

        return bookService.checkoutBook(userEmail, bookId);
    }



}
