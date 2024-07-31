package be.azz.java.ulfgarstoolbox.common.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validator checking that the associated field follows these rules :
 *      Minimum length of 8;
 *      at least 1 uppercase character;
 *      at least 1 lowercase character;
 *      at least 1 digit;
 *      at least 1 special character;
 */
@Retention(RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = PasswordConstraintValidator.class)
public @interface PasswordConstraint {

    String message() default "Password must be at least 8 characters long, contain one uppercase character, one lowercase character, one digit and one special character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
