package it.smartworki.dating_app.services;

import it.smartworki.dating_app.dtos.UserResponseDTO;
import it.smartworki.dating_app.entities.Message;
import it.smartworki.dating_app.fcm.FirebaseMessagingService;
import it.smartworki.dating_app.repositories.MessageRepository;
import it.smartworki.dating_app.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final FirebaseMessagingService firebaseMessagingService;

    public MessageService(MessageRepository messageRepository, FirebaseMessagingService firebaseMessagingService) {
        this.messageRepository = messageRepository;
        this.firebaseMessagingService = firebaseMessagingService;
    }

    @Transactional
    public Message sendMessage(User sender, User receiver, String content) {
        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setMessageType("text");
        message.setSentAt(LocalDateTime.now());
        message.setStatus("sent");

        messageRepository.save(message);
        return message;
    }
}
