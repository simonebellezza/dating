package it.smartworki.dating_app.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MessageResponseDTO {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String content;
    private LocalDateTime sentAt;
    private String messageType;
    private String status;
}
