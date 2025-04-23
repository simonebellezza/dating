package it.smartworki.dating_app.mappers;


import it.smartworki.dating_app.dtos.PreferenceResponseDTO;
import java.util.stream.Collectors;
import it.smartworki.dating_app.entities.Preference;

public class PreferenceMapper {

   public static PreferenceResponseDTO toDTO(Preference preference) {
        if (preference == null)
            return null;

        PreferenceResponseDTO preferenceResponseDTO = new PreferenceResponseDTO();

        preferenceResponseDTO.setMinAge(preference.getMinAge());
        preferenceResponseDTO.setMaxAge(preference.getMaxAge());
        preferenceResponseDTO.setDistance(preference.getDistance());

        preferenceResponseDTO.setGenres(preference.getGenres().stream()
                .map(GenreMapper::toDTO)
                .collect(Collectors.toSet()));

        return preferenceResponseDTO;
    }

    public static Preference toEntity(PreferenceResponseDTO preferenceResponseDTO) {
        if (preferenceResponseDTO == null)
            return null;

        Preference preference = new Preference();

        preference.setMinAge(preferenceResponseDTO.getMinAge());
        preference.setMaxAge(preferenceResponseDTO.getMaxAge());
        preference.setDistance(preferenceResponseDTO.getDistance());
        preference.setGenres(preferenceResponseDTO.getGenres().stream()
                .map(GenreMapper::toEntity)
                .collect(Collectors.toSet()));

        return preference;
    }
}
