package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.dao.UserRepository;
import com.library.spring_boot_library.entity.Message;
import com.library.spring_boot_library.service.MessagesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
