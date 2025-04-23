package it.smartworki.dating_app.controllers;

import it.smartworki.dating_app.dtos.DataMessageRequestDTO;
import it.smartworki.dating_app.fcm.FirebaseMessagingService;
import it.smartworki.dating_app.fcm.NotificationRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final FirebaseMessagingService messagingService;

    public NotificationController(FirebaseMessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequestDTO request) {
        String response = messagingService.sendNotification(request.token(), request.title(), request.body());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/send-data")
    public ResponseEntity<String> sendData(@RequestBody DataMessageRequestDTO request) {
        String response = messagingService.sendDataMessage(request.token(), request.data());
        return ResponseEntity.ok(response);
    }
}
