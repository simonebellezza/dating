package it.smartworki.dating_app.dtos;

import java.util.Map;

public record DataMessageRequestDTO(String token, Map<String, String> data) {}
