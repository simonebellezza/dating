package it.smartworki.dating_app.dtos;

import it.smartworki.dating_app.validators.ValidSwipeType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwipeDTO {

    @NotNull(message = "L'ID dell'utente è obbligatorio")
    private Long userId;

    @NotNull(message = "L'ID dell'utente target è obbligatorio")
    private Long targetId;

    @NotNull(message = "Il tipo di swipe è obbligatorio")
    @ValidSwipeType
    private String type;
}
