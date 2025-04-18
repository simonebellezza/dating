package it.smartworki.dating_app.controllers;

import it.smartworki.dating_app.dtos.PreferenceDTO;
import it.smartworki.dating_app.entities.Preference;
import it.smartworki.dating_app.services.PreferenceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    private final PreferenceService preferenceService;

    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @PatchMapping("/update")
    public ResponseEntity<PreferenceDTO> updatePreference(@RequestHeader("Authorization") String headerAuthorization, @RequestBody Preference preference) {
        String token = headerAuthorization.substring(7);
        PreferenceDTO preferenceDTO = preferenceService.updatePreference(token, preference);
        return ResponseEntity.ok(preferenceDTO);
    }
}
