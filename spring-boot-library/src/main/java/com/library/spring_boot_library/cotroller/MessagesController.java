package com.library.spring_boot_library.cotroller;

import com.library.spring_boot_library.dao.UserRepository;
import com.library.spring_boot_library.model.entity.Message;
import com.library.spring_boot_library.model.requestModels.AdminQuestionRequest;
import com.library.spring_boot_library.service.MessagesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/messages")
public class MessagesController {

    private final MessagesService messagesService;
    private final UserRepository userRepository;

    public MessagesController(MessagesService messagesService, UserRepository userRepository) {
        this.messagesService = messagesService;
        this.userRepository = userRepository;
    }

    @GetMapping("/search")
    public Page<Message> getNotClosedMessages(Pageable pageable) {
        return messagesService.getNotClosedUserMessages(pageable);
    }

    @GetMapping("/search/")
    public Page<Message> getMessages(@RequestParam String userEmail, Pageable pageable) {
        return messagesService.getMessagesSendByUser(userEmail, pageable);
    }

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestBody Message messageRequest, Principal principal) {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();

        messagesService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessage(Principal principal,@RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {
        String userEmail = userRepository.findByUsername(principal.getName()).orElseThrow().getEmail();


        messagesService.putMessage(adminQuestionRequest, userEmail);
    }
}
