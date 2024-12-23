package com.library.spring_boot_library.service;

import com.library.spring_boot_library.dao.MessageRepository;
import com.library.spring_boot_library.entity.Message;
import com.library.spring_boot_library.requestModels.AdminQuestionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MessagesService {

    private final MessageRepository messageRepository;

    public MessagesService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Page<Message> getNotClosedUserMessages(Pageable pageable) {
        return messageRepository.findByClosed(false, pageable);
    }

    public Page<Message> getMessagesSendByUser(String userEmail, Pageable pageable) {
        return messageRepository.findByUserEmail(userEmail,pageable);
    }

    public void postMessage(Message messageRequest, String userEmail) {
        Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());

        message.setUserEmail(userEmail);
        messageRepository.save(message);
    }

    public void putMessage(AdminQuestionRequest adminQuestionRequest, String userEmail) throws Exception{
        Optional<Message> message = messageRepository.findById(adminQuestionRequest.getId());

        if (message.isEmpty()) {
            throw new Exception("Message not found!");
        }

        message.get().setAdminEmail(userEmail);
        message.get().setResponse(adminQuestionRequest.getResponse());
        message.get().setClosed(true);
        messageRepository.save(message.get());
    }
}
