package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.dtos.MessageResponseDTO;
import it.smartworki.dating_app.entities.Message;

public class MessageMapper {

    public static MessageResponseDTO toDTO(Message message) {
        MessageResponseDTO dto = new MessageResponseDTO();
        dto.setId(message.getId());
        dto.setSenderId(message.getSender().getId());
        dto.setReceiverId(message.getReceiver().getId());
        dto.setContent(message.getContent());
        dto.setSentAt(message.getSentAt());
        dto.setMessageType(message.getMessageType());
        dto.setStatus(message.getStatus());
        return dto;
    }

}
