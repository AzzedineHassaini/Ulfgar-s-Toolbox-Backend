package be.tftic.java.ulfgarstoolbox.common.exceptions.domain;

import be.tftic.java.ulfgarstoolbox.common.exceptions.NotFoundException;

public class DomainNotFoundException extends NotFoundException {
    public DomainNotFoundException() {
        super("Domain not found.");
    }
}