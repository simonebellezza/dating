package it.smartworki.dating_app.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // la validazione di null è delegata a @NotNull
        }

        int age = Period.between(value, LocalDate.now()).getYears();

        if (age >= 18) {
            return true;
        }

        // Personalizzazione messaggio dinamico
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Hai solo " + age + " anni, serve almeno 18.")
                .addConstraintViolation();

        return false;
    }
}
