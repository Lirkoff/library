package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.dao.UserRepository;
import com.library.spring_boot_library.entity.Book;
import com.library.spring_boot_library.responseModels.ShelfCurrentLoansResponse;
import com.library.spring_boot_library.service.BookService;
import com.library.spring_boot_library.utils.JwtUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/books")
//@PreAuthorize("hasRole('ROLE_MODERATOR')")
public class BookController {
    private final BookService bookService;
    private final UserRepository userRepository;


    public BookController(BookService bookService, UserRepository userRepository) {
        this.bookService = bookService;
        this.userRepository = userRepository;
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


}
