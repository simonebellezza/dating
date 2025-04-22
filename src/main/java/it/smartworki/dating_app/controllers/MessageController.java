package it.smartworki.dating_app.controllers;

import it.smartworki.dating_app.dtos.SendMessageRequestDTO;
import it.smartworki.dating_app.dtos.UserResponseDTO;
import it.smartworki.dating_app.services.MessageService;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;

    public MessageController(
            MessageService messageService,
            UserService userService
    ) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody SendMessageRequestDTO request
    ) {
        String token = authorizationHeader.replace("Bearer ", "");

        User sender = userService.findEntityByToken(token);
        User receiver = userService.findEntityById(request.getReceiverId());

        messageService.sendMessage(sender, receiver, request.getContent());

        return ResponseEntity.ok("Messaggio inviato con successo");
    }
}
