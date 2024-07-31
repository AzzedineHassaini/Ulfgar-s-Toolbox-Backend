package be.azz.java.ulfgarstoolbox.common.exceptions.auth;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotAllowedException;

public class LoginFailedException extends NotAllowedException {
    public LoginFailedException() {
        super("Email/Mot de passe invalide");
    }
}
