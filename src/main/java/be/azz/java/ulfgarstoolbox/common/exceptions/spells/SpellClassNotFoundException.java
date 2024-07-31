package be.azz.java.ulfgarstoolbox.common.exceptions.spells;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class SpellClassNotFoundException extends NotFoundException {
    public SpellClassNotFoundException() {
        super("Spellclass not found.");
    }
}