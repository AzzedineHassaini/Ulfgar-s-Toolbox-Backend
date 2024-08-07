package be.azz.java.ulfgarstoolbox.common.dtos.auth.requests;

import be.azz.java.ulfgarstoolbox.common.annotations.PasswordConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(

        @NotBlank(message = "There must be an email")
        @Email(message = "The email is not valid")
        String email,

        @NotNull(message = "There must be a password")
        @PasswordConstraint
        String password,

        @NotBlank(message = "There must be a pseudo")
        String pseudo,

        String image
) {
}
