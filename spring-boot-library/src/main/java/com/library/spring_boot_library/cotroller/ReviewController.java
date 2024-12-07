package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.dao.UserRepository;
import com.library.spring_boot_library.entity.UserEntity;
import com.library.spring_boot_library.requestModels.ReviewRequest;
import com.library.spring_boot_library.service.ReviewService;
import com.library.spring_boot_library.utils.JwtUtils;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    public ReviewController(ReviewService reviewService, JwtUtils jwtUtils, UserRepository userRepository) {
        this.reviewService = reviewService;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
    }

    @GetMapping("/secure/user/book/")
    public Boolean reviewBookByUser(@RequestParam Long bookId, Principal principal) throws Exception{
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();

        if (userEmail == null) {
            throw new Exception("User not found");
        }

        return reviewService.userReviewListed(userEmail, bookId);
    }

    @PostMapping("/secure")
    public void postReview(@RequestBody ReviewRequest reviewRequest, Principal principal) throws Exception{
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();


        if (userEmail == null) {
            throw new Exception("User not found");
        }

        reviewService.postReview(userEmail, reviewRequest);
    }
}
