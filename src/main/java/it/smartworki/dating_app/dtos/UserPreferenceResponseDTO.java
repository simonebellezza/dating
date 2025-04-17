package it.smartworki.dating_app.dtos;

import it.smartworki.dating_app.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserPreferenceResponseDTO {
    private Integer minAge;
    private Integer maxAge;
    private Long distance;
    private Set<Genre> genres;
}