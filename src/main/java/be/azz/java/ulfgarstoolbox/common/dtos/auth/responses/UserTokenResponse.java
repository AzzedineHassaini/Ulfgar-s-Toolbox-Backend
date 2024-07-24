package be.azz.java.ulfgarstoolbox.common.dtos.auth.responses;

import be.azz.java.ulfgarstoolbox.common.dtos.user.responses.UserShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.User;

public record UserTokenResponse(
        UserShortResponse user,
        String accessToken

) {
    public static UserTokenResponse fromEntityWithToken(User user, String token) {
        return new UserTokenResponse(
                new UserShortResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getPseudo(),
                        user.getRole().toString()
                ),
                token
        );
    }
}
