package it.smartworki.dating_app.validators;

import it.smartworki.dating_app.entities.enums.SwipeType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SwipeTypeValidator implements ConstraintValidator<ValidSwipeType, String> {

    private Set<String> validValues;

    @Override
    public void initialize(ValidSwipeType constraintAnnotation) {
        validValues = Arrays.stream(SwipeType.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        boolean valid = validValues.contains(value.toUpperCase());

        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Tipo di swipe '" + value + "' non valido. Valori ammessi: " + validValues
            ).addConstraintViolation();
        }

        return valid;
    }
}
