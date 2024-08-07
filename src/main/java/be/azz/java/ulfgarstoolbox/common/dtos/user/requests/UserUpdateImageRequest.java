package be.azz.java.ulfgarstoolbox.common.dtos.user.requests;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateImageRequest(
        @NotBlank(message ="image is required")
        String image
) {
}
