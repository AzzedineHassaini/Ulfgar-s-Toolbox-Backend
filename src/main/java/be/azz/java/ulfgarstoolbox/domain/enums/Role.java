package be.azz.java.ulfgarstoolbox.domain.enums;

public enum Role {

    USER("USER"),
    CONTRIBUTOR("CONTRIBUTOR"),
    ADMIN("ADMIN");

    public final String label;

    Role(String label){
        this.label = label;
    }

}
