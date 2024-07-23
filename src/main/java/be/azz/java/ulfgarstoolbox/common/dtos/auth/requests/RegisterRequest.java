package be.azz.java.ulfgarstoolbox.common.dtos.auth.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequest(

        @NotBlank(message = "There must be an email")
        @Email(message = "The email is not valid")
        String email,

        @NotNull(message = "There must be a phone number")
        @Size(min = 8, message = "Password must be 8 characters minimum")
        String password,

        @NotBlank(message = "There must be a pseudo")
        String pseudo
) {
}
