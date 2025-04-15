package it.smartworki.dating_app.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwipeRequestDTO {

    @NotEmpty(message = "L'ID dell'utente è obbligatorio")
    private Long userId;

    @NotEmpty(message = "L'ID dell'utente target è obbligatorio")
    private Long targetId;

    @NotEmpty(message = "Il tipo di swipe è obbligatorio") // Aggiornare con validazione personalizzata
    // verificare i tipi presenti in SwipeType
    private String type;
}