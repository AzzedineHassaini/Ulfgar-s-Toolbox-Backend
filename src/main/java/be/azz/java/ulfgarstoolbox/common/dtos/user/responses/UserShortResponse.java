package be.azz.java.ulfgarstoolbox.common.dtos.user.responses;

public record UserShortResponse(
        Long id,
        String email,
        String pseudo,
        String role
) { }

