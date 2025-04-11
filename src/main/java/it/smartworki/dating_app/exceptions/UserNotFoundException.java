package it.smartworki.dating_app.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Utente non trovato");
    }

    public UserNotFoundException(Long id) {
        super(String.format("Utente con id %d non trovato", id));
    }
}
