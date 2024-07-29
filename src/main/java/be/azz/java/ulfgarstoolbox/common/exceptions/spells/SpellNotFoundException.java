package be.azz.java.ulfgarstoolbox.common.exceptions.spells;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class SpellNotFoundException extends NotFoundException {
    public SpellNotFoundException() {
        super("Spell not found.");
    }
}