package it.smartworki.dating_app.fcm;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FirebaseMessagingService {

    public String sendNotification(String deviceToken, String title, String body) {
        Notification notification = Notification.builder()
                .setTitle(title)
                .setBody(body)
                .build();

        Message message = Message.builder()
                .setToken(deviceToken)
                .setNotification(notification)
                .build();

        try {
            return com.google.firebase.messaging.FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException("Errore durante l'invio della notifica", e);
        }
    }

    public String sendDataMessage(String deviceToken, Map<String, String> data) {
        Message message = Message.builder()
                .putAllData(data)
                .setToken(deviceToken)
                .build();

        try {
            return com.google.firebase.messaging.FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException("Errore durante l'invio del messaggio dati", e);
        }
    }
}