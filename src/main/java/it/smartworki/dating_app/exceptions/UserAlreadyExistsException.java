package it.smartworki.dating_app.exceptions;

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
}
