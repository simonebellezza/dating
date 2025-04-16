package it.smartworki.dating_app.mappers;

import it.smartworki.dating_app.converters.DateConverter;
import it.smartworki.dating_app.dtos.UserPreferenceResponseDTO;
import it.smartworki.dating_app.entities.Preference;

public class PreferenceMapper {
    public static UserPreferenceResponseDTO toDTO(Preference preference) {
        if (preference == null)
            return null;

        UserPreferenceResponseDTO preferenceDTO = new UserPreferenceResponseDTO();

        preferenceDTO.setMinAge(preference.getMinAge());
        preferenceDTO.setMaxAge(preference.getMaxAge());
        preferenceDTO.setDistance(preference.getDistance());
        preferenceDTO.setGenres(preference.getGenres());

        return preferenceDTO;
    }

    public static Preference toEntity(UserPreferenceResponseDTO preferenceRequestDTO) {
        if (preferenceRequestDTO == null)
            return null;

        Preference preference = new Preference();

        preference.setMinAge(preferenceRequestDTO.getMinAge());
        preference.setMaxAge(preferenceRequestDTO.getMaxAge());
        preference.setDistance(preferenceRequestDTO.getDistance());
        preference.setGenres(preferenceRequestDTO.getGenres());

        return preference;
    }
}
