package it.smartworki.dating_app.fcm;

public record NotificationRequestDTO(String token, String title, String body) {}