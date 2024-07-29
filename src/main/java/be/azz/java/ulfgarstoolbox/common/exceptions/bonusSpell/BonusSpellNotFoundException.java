package be.azz.java.ulfgarstoolbox.common.exceptions.bonusSpell;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class BonusSpellNotFoundException extends NotFoundException {

    public BonusSpellNotFoundException() {
        super("Bonus Spell does not exist !");
    }
}
