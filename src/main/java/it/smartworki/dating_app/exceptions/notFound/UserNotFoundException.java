package it.smartworki.dating_app.exceptions.notFound;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Utente non trovato");
    }

    public UserNotFoundException(Long id) {
        super(String.format("Utente con id %d non trovato", id));
    }

    public UserNotFoundException(String email) {
        super(String.format("Utente con email %s non trovato", email));
    }
}
