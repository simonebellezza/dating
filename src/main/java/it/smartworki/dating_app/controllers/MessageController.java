package it.smartworki.dating_app.controllers;

import it.smartworki.dating_app.dtos.SendMessageRequestDTO;
import it.smartworki.dating_app.dtos.MessageResponseDTO;
import it.smartworki.dating_app.dtos.DeviceTokenRequestDTO;
import it.smartworki.dating_app.entities.Message;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.mappers.MessageMapper;
import it.smartworki.dating_app.services.MessageService;
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

    @PostMapping
    public ResponseEntity<MessageResponseDTO> sendMessage(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody SendMessageRequestDTO request
    ) {
        String token = authorizationHeader.replace("Bearer ", "");
        User sender = userService.findEntityByToken(token);
        User receiver = userService.findEntityById(request.getReceiverId());

        Message message = messageService.sendMessage(sender, receiver, request.getContent());
        MessageResponseDTO responseDTO = MessageMapper.toDTO(message);

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/device-token")
    public ResponseEntity<Void> updateDeviceToken(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody DeviceTokenRequestDTO requestDTO
    ) {
        String jwt = authorizationHeader.replace("Bearer ", "");
        userService.saveDeviceToken(jwt, requestDTO.fmcToken());
        return ResponseEntity.ok().build();
    }
}
