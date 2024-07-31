package be.azz.java.ulfgarstoolbox.common.exceptions.spells;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class SpellDomainNotFoundException extends NotFoundException {
    public SpellDomainNotFoundException() {
        super("Spelldomain not found.");
    }
}
