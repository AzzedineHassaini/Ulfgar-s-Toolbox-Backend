package be.azz.java.ulfgarstoolbox.domain.enums;

public enum Ability {

    FOR("Force"),
    DEX("Dexterité"),
    CON("Constitution"),
    INT("Intelligence"),
    SAG("Sagesse"),
    CHA("Charisme");

    public final String fullName;

    Ability(String fullName){
        this.fullName = fullName;
    }


}
