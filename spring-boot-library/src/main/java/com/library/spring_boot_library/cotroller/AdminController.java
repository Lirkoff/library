package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.requestModels.AddBookRequest;
import com.library.spring_boot_library.service.AdminService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/secure/increase/book/quantity/")
    public void increaseBookQuantity(@RequestParam Long bookId) throws Exception{


        adminService.increaseBookQuantity(bookId);
    }

    @PutMapping("/secure/decrease/book/quantity/")
    public void decreaseBookQuantity(@RequestParam Long bookId) throws Exception{

        adminService.decreaseBookQuantity(bookId);
    }

    @PostMapping("/secure/add/book")
    public void postBook(@RequestBody AddBookRequest addBookRequest) throws Exception {

        adminService.postBook(addBookRequest);
    }

    @DeleteMapping("/secure/delete/book/")
    public void deleteBook(@RequestParam Long bookId) throws Exception {

        adminService.deleteBook(bookId);
    }

}
