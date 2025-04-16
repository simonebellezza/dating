package it.smartworki.dating_app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserPreferenceResponseDTO {
    private Integer minAge;
    private Integer maxAge;
    private Long distance;
}