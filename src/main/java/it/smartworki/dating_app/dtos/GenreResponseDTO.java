package it.smartworki.dating_app.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GenreResponseDTO {

    @NotEmpty(message = "id cannot be empty")
    private short id;

    @NotEmpty(message = "type cannot be empty")
    private String type;
}
