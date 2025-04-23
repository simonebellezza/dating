package it.smartworki.dating_app.dtos;

import lombok.Data;

@Data
public class SendMessageRequestDTO {
    private Long receiverId;
    private String content;
}