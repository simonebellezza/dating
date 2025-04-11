package it.smartworki.dating_app.controllers.exceptions;

import it.smartworki.dating_app.exceptions.ApiException;
import it.smartworki.dating_app.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {
    // NotFoundException
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiException> notFoundExceptionHandler(
            RuntimeException e,
            HttpServletRequest request
    ) {
        ApiException apiException = new ApiException();

        apiException.setStatus(HttpStatus.NOT_FOUND.value());  // 404
        apiException.setError(HttpStatus.NOT_FOUND.getReasonPhrase());  // "Not Found"
        apiException.setMessage(e.getMessage());
        apiException.setTimestamp(LocalDateTime.now());
        apiException.setPath(request.getMethod() + " " + request.getRequestURI());  // Es. "GET /api/users/{id}"

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    // Exception generica
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> genericExceptionHandler(
            Exception e,
            HttpServletRequest request
    ) {
        ApiException apiException = new ApiException();

        apiException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());  // 500
        apiException.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());  // "Internal server error"
        apiException.setMessage(e.getMessage());
        apiException.setTimestamp(LocalDateTime.now());
        apiException.setPath(request.getMethod() + " " + request.getRequestURI());

        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
