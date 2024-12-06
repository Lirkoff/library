package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.requestModels.AddBookRequest;
import com.library.spring_boot_library.service.AdminService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/secure/add/book")
    public void postBook(Principal principal, Authentication authentication, @RequestBody AddBookRequest addBookRequest) throws Exception {
        String roles = authentication.getAuthorities().toString().split(",")[1].replace("]", "");

        if (!roles.contains("ROLE_ADMIN") || !roles.contains("ROLE_MODERATOR")) {
            throw new Exception("Administration page only!");
        }

        adminService.postBook(addBookRequest);
    }

}
