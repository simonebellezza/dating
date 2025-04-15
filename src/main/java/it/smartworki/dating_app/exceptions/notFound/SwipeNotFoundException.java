package it.smartworki.dating_app.exceptions.notFound;

public class SwipeNotFoundException extends RuntimeException {
    public SwipeNotFoundException() {
        super("Swipe non trovato");
    }

    public SwipeNotFoundException(Long id) {
        super(String.format("Swipe con id %d non trovato", id));
    }

    public SwipeNotFoundException(Long userId, Long userTargetId) {
        super(String.format("Swipe tra utente con id %d e utente con id %d non trovato", userId, userTargetId));
    }
}