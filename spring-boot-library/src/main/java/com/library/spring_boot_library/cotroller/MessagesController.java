package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.dao.UserRepository;
import com.library.spring_boot_library.entity.Message;
import com.library.spring_boot_library.requestModels.AdminQuestionRequest;
import com.library.spring_boot_library.service.MessagesService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/api/messages")
public class MessagesController {

    private final MessagesService messagesService;
    private final UserRepository userRepository;

    public MessagesController(MessagesService messagesService, UserRepository userRepository) {
        this.messagesService = messagesService;
        this.userRepository = userRepository;
    }

    @PostMapping("/secure/add/message/")
    public void postMessage(Principal principal, @RequestBody Message messageRequest) {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();

        messagesService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message/")
    public void putMessage(Principal principal, Authentication authentication, @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();
        String admin = authentication.getAuthorities().toString().split(",")[1].replace("]", "");

        if (!admin.contains("ROLE_ADMIN") || !admin.contains("ROLE_MODERATOR")) {
            throw new Exception("Administration page only!");
        }

        messagesService.putMessage(adminQuestionRequest, userEmail);
    }
}
