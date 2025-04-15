package it.smartworki.dating_app.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequestDTO {

    @NotEmpty(message = "L'ID dell'utente è obbligatorio")
    private Long userId;

    @NotEmpty(message = "L'ID dell'utente target è obbligatorio")
    private Long targetId;
}
