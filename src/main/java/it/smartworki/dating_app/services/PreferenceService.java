package it.smartworki.dating_app.services;

import it.smartworki.dating_app.dtos.PreferenceRequestDTO;
import it.smartworki.dating_app.dtos.PreferenceResponseDTO;
import it.smartworki.dating_app.entities.Genre;
import it.smartworki.dating_app.entities.Preference;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.mappers.PreferenceMapper;
import it.smartworki.dating_app.repositories.GenreRepository;
import it.smartworki.dating_app.repositories.PreferenceRepository;
import it.smartworki.dating_app.repositories.UserRepository;
import it.smartworki.dating_app.security.JWTUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final JWTUtils jwt;
    private final UserRepository userRepository;
    private final GenreRepository genreRepository;

    public PreferenceService(
            PreferenceRepository
                    preferenceRepository,
            JWTUtils jwt,
            UserRepository userRepository,
            GenreRepository genreRepository
    ) {
        this.preferenceRepository = preferenceRepository;
        this.jwt = jwt;
        this.userRepository = userRepository;
        this.genreRepository = genreRepository;
    }

    public PreferenceResponseDTO updatePreference(
            String email,
            PreferenceRequestDTO preferenceRequestDTO
    ) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Preference preference = user.getPreference();
        if (preference == null) {
            preference = new Preference();
            preference.setUser(user);
        }

        preference.setMinAge(preferenceRequestDTO.getMinAge());
        preference.setMaxAge(preferenceRequestDTO.getMaxAge());
        preference.setDistance(preferenceRequestDTO.getDistance());

        Set<Genre> genres = new HashSet<>(
                genreRepository.findAllById(preferenceRequestDTO.getGenres()));
        preference.setGenres(genres);

        Preference saved = preferenceRepository.save(preference);
        return PreferenceMapper.toDTO(saved);
    }
}
