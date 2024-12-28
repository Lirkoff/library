package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.dao.UserRepository;
import com.library.spring_boot_library.model.entity.Review;
import com.library.spring_boot_library.model.requestModels.ReviewRequest;
import com.library.spring_boot_library.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;



@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final UserRepository userRepository;

    public ReviewController(ReviewService reviewService, UserRepository userRepository) {
        this.reviewService = reviewService;
        this.userRepository = userRepository;
    }


    @GetMapping("/search/{bookId}")
    public Page<Review> getReviewsByBookId(@PathVariable("bookId") Long bookId, Pageable pageable) {

        return reviewService.reviewsByBookId(bookId, pageable);
    }

    @GetMapping("/secure/user/book/")
    public Boolean reviewBookByUser(@RequestParam Long bookId, Principal principal) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();

        if (userEmail == null) {
            throw new Exception("User not found");
        }

        return reviewService.userReviewListed(userEmail, bookId);
    }

    @PostMapping("/secure")
    public void postReview(@RequestBody ReviewRequest reviewRequest, Principal principal) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();


        if (userEmail == null) {
            throw new Exception("User not found");
        }

        reviewService.postReview(userEmail, reviewRequest);
    }
}
