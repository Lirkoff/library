package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.dao.UserRepository;
import com.library.spring_boot_library.entity.Book;
import com.library.spring_boot_library.entity.History;
import com.library.spring_boot_library.responseModels.ShelfCurrentLoansResponse;
import com.library.spring_boot_library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    private final UserRepository userRepository;


    public BookController(BookService bookService, UserRepository userRepository) {
        this.bookService = bookService;
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public ResponseEntity<Page<Book>> fetchBooks(Pageable pageable) {

        return ResponseEntity.of(Optional.ofNullable(bookService.allBooks(pageable)));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> fetchBooks(@PathVariable("bookId") Long bookId) {

        return ResponseEntity.of(Optional.ofNullable(bookService.getBookById(bookId)));
    }

    @GetMapping("/secure/currentloans")
    public List<ShelfCurrentLoansResponse> currentLoans(Principal principal) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();

        return bookService.currentLoans(userEmail);
    }



    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount(Principal principal) {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();


        return bookService.currentLoansCount(userEmail);
    }

    @GetMapping("/secure/ischeckedout/byuser/")
    public Boolean checkoutBookByUser(@RequestParam Long bookId, Principal principal) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();


        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @PutMapping("/secure/checkout/")
    public Book checkoutBook(@RequestParam Long bookId, Principal principal) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();


        return bookService.checkoutBook(userEmail, bookId);
    }


    @PutMapping("/secure/return/")
    public void returnBook(@RequestParam Long bookId, Principal principal) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();

        bookService.returnBook(userEmail, bookId);
    }

    @PutMapping("/secure/renew/loan/")
    public void renewLoan(@RequestParam Long bookId, Principal principal) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();

        bookService.renewLoan(userEmail, bookId);
    }


}
