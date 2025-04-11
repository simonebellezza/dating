package it.smartworki.dating_app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiException {
    private int status;  // Es. 404
    private String error;  // Es. "Not found"
    private String message;  // Es. "Utente non trovato"
    private LocalDateTime timestamp;
    private String path;  // Es. "GET /api/users/{id}"
}
