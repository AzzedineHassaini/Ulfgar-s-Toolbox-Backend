package be.azz.java.ulfgarstoolbox.common.exceptions.auth;

import be.azz.java.ulfgarstoolbox.common.exceptions.AlreadyExistsException;

public class UserAlreadyExistsException extends AlreadyExistsException {

    public UserAlreadyExistsException() {
        super("User already exists !");
    }
}
