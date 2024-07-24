package be.azz.java.ulfgarstoolbox.common.exceptions.characterClass;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class CharacterClassNotFoundException extends NotFoundException {
    public CharacterClassNotFoundException() {
        super("Class not found.");
    }
}