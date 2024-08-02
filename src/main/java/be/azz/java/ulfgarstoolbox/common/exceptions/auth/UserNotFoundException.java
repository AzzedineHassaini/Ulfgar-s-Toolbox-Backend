package be.azz.java.ulfgarstoolbox.common.exceptions.auth;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super("Utilisateur introuvable");
    }
}
