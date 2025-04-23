package it.smartworki.dating_app.exceptions.alreadyExists;

import java.util.List;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("Utente già esistente");
    }

    public UserAlreadyExistsException(Long id) {
        super(String.format("Utente con id %d già esistente", id));
    }

    public UserAlreadyExistsException(String email) {
        super(String.format("Utente con email %s già esistente", email));
    }

    public UserAlreadyExistsException(List<String> emails) {
        super(String.format("Utenti con email %s già esistenti", String.join(", ", emails)));
    }
}
