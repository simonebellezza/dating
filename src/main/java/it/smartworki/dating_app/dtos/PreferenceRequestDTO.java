package it.smartworki.dating_app.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
public class PreferenceRequestDTO {

    @NotNull(message = "Min age cannot be null")
    @Min(value = 18, message = "Min age must be at least 18")
    private Integer minAge;

    @NotNull(message = "Max age cannot be null")
    @Min(value = 18, message = "Max age must be at least 18")
    @Max(value = 150, message = "Max age must be less than or equal to 150")
    private Integer maxAge;

    @NotNull(message = "Distance cannot be null")
    @Positive(message = "Distance must be a positive number")
    private Long distance;

    @NotEmpty(message = "Genres cannot be empty")
    private Set<Short> genres;
}
