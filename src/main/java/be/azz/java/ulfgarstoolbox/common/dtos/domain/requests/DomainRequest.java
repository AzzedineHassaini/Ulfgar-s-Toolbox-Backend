package be.azz.java.ulfgarstoolbox.common.dtos.domain.requests;

import jakarta.validation.constraints.NotBlank;

public record DomainRequest(
        @NotBlank(message = "Domain name cannot be blank")
        String name,

        @NotBlank(message = "Power description cannot be blank")
        String power
) {
}
