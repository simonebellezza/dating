package it.smartworki.dating_app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
public class GenreDTO {

    @NotEmpty(message = "id cannot be empty")
    private short id;

    @NotEmpty(message = "type cannot be empty")
    private String type;
}
