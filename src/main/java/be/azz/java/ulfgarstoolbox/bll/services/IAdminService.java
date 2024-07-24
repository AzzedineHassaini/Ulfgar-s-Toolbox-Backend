package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.user.requests.UserUpdateRoleRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.user.responses.UserShortResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.UserNotFoundException;

import java.util.List;

public interface IAdminService {

    /**
     * Update the role of an existing user.
     * @param id of the user that will be updated
     * @param request, body containing role of the user
     * @return a UserTokenResponse object containing the user's details and authentication token
     * @throws UserNotFoundException if a user with the provided username does not exist in the database
     */
    UserShortResponse updateRole(Long id, UserUpdateRoleRequest request);

    UserShortResponse deleteUser(Long id);

    List<UserShortResponse> getAllUsers();

}
