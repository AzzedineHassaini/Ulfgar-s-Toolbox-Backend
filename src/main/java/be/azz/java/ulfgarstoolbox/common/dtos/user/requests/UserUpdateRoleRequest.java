package be.azz.java.ulfgarstoolbox.common.dtos.user.requests;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateRoleRequest(
        @NotBlank(message ="Role is required")
        String role
) {
}
