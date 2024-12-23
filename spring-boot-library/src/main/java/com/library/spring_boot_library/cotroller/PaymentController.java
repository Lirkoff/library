package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.dao.UserRepository;
import com.library.spring_boot_library.requestModels.PaymentInfoRequest;
import com.library.spring_boot_library.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/api/payment/secure")
public class PaymentController {

    private final PaymentService paymentService;
    private final UserRepository userRepository;

    public PaymentController(PaymentService paymentService, UserRepository userRepository) {
        this.paymentService = paymentService;
        this.userRepository = userRepository;
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest) throws StripeException {
        PaymentIntent paymentIntent = paymentService.createPaymentIntent(paymentInfoRequest);
        String paymentStr = paymentIntent.toJson();

        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }

    @PutMapping("/payment-complete")
    public ResponseEntity<String> stripePaymentComplete(Principal principal) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();

        if (userEmail == null) {
            throw new Exception("User email is missing");
        }

        return paymentService.stripePayment(userEmail);
    }
}
