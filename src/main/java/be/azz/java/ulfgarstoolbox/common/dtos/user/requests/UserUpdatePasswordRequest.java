package be.azz.java.ulfgarstoolbox.common.dtos.user.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
        @Size(min = 8, message = "Password must be 8 characters minimum")
        String newPassword
) {
}
