package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.dtos.SwipeDTO;
import it.smartworki.dating_app.entities.Swipe;
import it.smartworki.dating_app.entities.enums.SwipeType;

public class SwipeMapper {

    public static SwipeDTO toDTO(Swipe swipe) {
        SwipeDTO dto = new SwipeDTO();
        dto.setUserId(swipe.getUser().getId());
        dto.setTargetId(swipe.getUserTarget().getId());
        dto.setType(swipe.getType().name());
        return dto;
    }

    public static Swipe toEntity(SwipeDTO dto) {
        Swipe swipe = new Swipe();
        swipe.setType(SwipeType.valueOf(dto.getType()));
        return swipe;
    }

}
