package it.smartworki.dating_app.dtos;

import it.smartworki.dating_app.entities.Genre;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Data
public class PreferenceDTO {

    @NotEmpty(message = "Genres cannot be empty")
    private Integer minAge;

    @NotEmpty(message = "Genres cannot be empty")
    private Integer maxAge;

    @NotEmpty(message = "Genres cannot be empty")
    private Long distance;

    @NotEmpty(message = "Genres cannot be empty")
    private Set<GenreDTO> genres;
}
