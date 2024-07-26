package be.azz.java.ulfgarstoolbox.domain.enums;

public enum Ability {

    STRENGTH("FOR"),
    DEXTERITY("DEX"),
    CONSTITUTION("CON"),
    INTELLIGENCE("INT"),
    WISDOM("SAG"),
    CHARISMA("CHA");

    public final String shortName;

    Ability(String shortName){
        this.shortName = shortName;
    }

}
