package be.azz.java.ulfgarstoolbox.common.exceptions.ruleBook;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class RuleBookNotFoundException extends NotFoundException {
    public RuleBookNotFoundException() {
        super("Rule book not found.");
    }
}