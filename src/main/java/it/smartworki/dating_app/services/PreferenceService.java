package it.smartworki.dating_app.services;

import it.smartworki.dating_app.dtos.PreferenceDTO;
import it.smartworki.dating_app.entities.Preference;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.mappers.PreferenceMapper;
import it.smartworki.dating_app.repositories.PreferenceRepository;
import it.smartworki.dating_app.repositories.UserRepository;
import it.smartworki.dating_app.security.JWTUtils;
import org.springframework.stereotype.Service;

@Service
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final JWTUtils jwts;
    private final UserRepository userRepository;

    public PreferenceService(PreferenceRepository preferenceRepository, JWTUtils jwts, UserRepository userRepository) {
        this.preferenceRepository = preferenceRepository;
        this.jwts = jwts;
        this.userRepository = userRepository;
    }

    // updatePreference method
    public PreferenceDTO updatePreference(String token, Preference preference){
        String email = jwts.getUsername(token);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        preferenceRepository.save(user.getPreference());
        return PreferenceMapper.toPreferenceDTO(user.getPreference());
    }

}
