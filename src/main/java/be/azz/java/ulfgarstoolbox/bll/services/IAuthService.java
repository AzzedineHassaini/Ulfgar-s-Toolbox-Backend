package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.auth.requests.LoginRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.auth.requests.RegisterRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.auth.responses.UserTokenResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.InvalidPasswordException;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.UserAlreadyExistsException;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.UserNotFoundException;
import be.azz.java.ulfgarstoolbox.domain.enums.Role;

public interface IAuthService {

    /**
     * Authenticates a user with the provided login credentials.
     * @param request the login request containing the user's username and password
     * @return a UserTokenResponse object containing the user's details and authentication token
     * @throws InvalidPasswordException if the provided password does not match the one stored in the database
     * @throws UserNotFoundException if a user with the provided username does not exist in the database
     */
    UserTokenResponse login(LoginRequest request);

    /**
     * Registers a new user in the system.
     * @param request the registration request containing the user's details and desired user type
     * @return a UserTokenResponse object containing the user's details and authentication token
     * @throws UserAlreadyExistsException if a user with the provided email already exists in the database
     */
    UserTokenResponse register(RegisterRequest request, Role role);

}
