package it.smartworki.dating_app.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GenreRequestDTO {

    @NotEmpty(message = "id cannot be empty")
    private short id;
}
