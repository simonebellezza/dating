package it.smartworki.dating_app.controllers.exceptions;

import it.smartworki.dating_app.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundHandler(UserNotFoundException e) {
        return e.getMessage();
    }
}
