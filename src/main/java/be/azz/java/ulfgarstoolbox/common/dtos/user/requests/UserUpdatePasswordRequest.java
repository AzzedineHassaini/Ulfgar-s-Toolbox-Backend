package be.azz.java.ulfgarstoolbox.common.dtos.user.requests;

import be.azz.java.ulfgarstoolbox.common.annotations.PasswordConstraint;
import jakarta.validation.constraints.NotBlank;

/**
 * The request model for changing the user password
 * <p>This record encapsulate de old password and the new password</p>
 * @param oldPassword
 * @param newPassword
 */
public record UserUpdatePasswordRequest(
        @NotBlank(message ="password is required")
        String oldPassword,

        @NotBlank(message = "password is required")
        @PasswordConstraint
        String newPassword
) {
}
