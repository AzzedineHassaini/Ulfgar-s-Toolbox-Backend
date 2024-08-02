package be.azz.java.ulfgarstoolbox.common.exceptions.domain;

import be.azz.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class DomainNotFoundException extends NotFoundException {
    public DomainNotFoundException() {
        super("Domain not found.");
    }
}