package it.smartworki.dating_app.mappers;


import it.smartworki.dating_app.dtos.PreferenceDTO;
import it.smartworki.dating_app.dtos.UserPreferenceResponseDTO;
import java.util.stream.Collectors;
import it.smartworki.dating_app.entities.Preference;

public class PreferenceMapper {
    public static UserPreferenceResponseDTO toUserPreferenceDTO(Preference preference) {
        if (preference == null)
            return null;

        UserPreferenceResponseDTO preferenceDTO = new UserPreferenceResponseDTO();

        preferenceDTO.setMinAge(preference.getMinAge());
        preferenceDTO.setMaxAge(preference.getMaxAge());
        preferenceDTO.setDistance(preference.getDistance());
        preferenceDTO.setGenres(preference.getGenres());

        return preferenceDTO;
    }

    public static PreferenceDTO toPreferenceDTO(Preference preference) {
        if (preference == null)
            return null;

        PreferenceDTO preferenceDTO = new PreferenceDTO();

        preferenceDTO.setMinAge(preference.getMinAge());
        preferenceDTO.setMaxAge(preference.getMaxAge());
        preferenceDTO.setDistance(preference.getDistance());

        // Mappare il Set di Genre in un Set di GenreDTO
        preferenceDTO.setGenres(preference.getGenres().stream()
                .map(GenreMapper::toDTO) // Usa il GenreMapper per convertire Genre in GenreDTO
                .collect(Collectors.toSet()));

        return preferenceDTO;
    }





//    public static Preference toEntity(UserPreferenceResponseDTO preferenceRequestDTO) {
//        if (preferenceRequestDTO == null)
//            return null;
//
//        Preference preference = new Preference();
//
//        preference.setMinAge(preferenceRequestDTO.getMinAge());
//        preference.setMaxAge(preferenceRequestDTO.getMaxAge());
//        preference.setDistance(preferenceRequestDTO.getDistance());
//        preference.setGenres(preferenceRequestDTO.getGenres());
//
//        return preference;
//    }
}
