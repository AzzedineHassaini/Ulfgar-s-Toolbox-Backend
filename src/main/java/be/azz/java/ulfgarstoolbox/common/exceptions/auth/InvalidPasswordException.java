package be.azz.java.ulfgarstoolbox.common.exceptions.auth;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotAllowedException;

public class InvalidPasswordException extends NotAllowedException {
    public InvalidPasswordException() {
        super("Invalid password!");
    }
}
