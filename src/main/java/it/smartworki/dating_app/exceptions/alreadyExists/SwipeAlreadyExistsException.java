package it.smartworki.dating_app.exceptions.alreadyExists;

public class SwipeAlreadyExistsException extends RuntimeException {
    public SwipeAlreadyExistsException() {
        super("Swipe già esistente");
    }

    public SwipeAlreadyExistsException(Long id) {
        super(String.format("Swipe con id %d già esistente", id));
    }

    public SwipeAlreadyExistsException(Long userId, Long userTargetId) {
        super(String.format("Swipe tra utente con id %d e utente con id %d già esistente", userId, userTargetId));
    }
}