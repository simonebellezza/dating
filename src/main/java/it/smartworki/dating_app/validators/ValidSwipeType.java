package it.smartworki.dating_app.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SwipeTypeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSwipeType {

    String message() default "Tipo di swipe non valido. Valori ammessi: LIKE, PASS, SUPER_LIKE";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
