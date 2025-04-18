package it.smartworki.dating_app.controllers;

import it.smartworki.dating_app.dtos.PreferenceRequestDTO;
import it.smartworki.dating_app.dtos.PreferenceResponseDTO;
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

    @PatchMapping
    public ResponseEntity<PreferenceResponseDTO> updatePreference(
            @RequestHeader("Authorization") String headerAuthorization,
            @RequestBody @Valid PreferenceRequestDTO preferenceRequestDTO) {
        String token = headerAuthorization.substring(7);
        PreferenceResponseDTO updatedPreference = preferenceService.updatePreference(token, preferenceRequestDTO);
        return ResponseEntity.ok(updatedPreference);
    }
}
