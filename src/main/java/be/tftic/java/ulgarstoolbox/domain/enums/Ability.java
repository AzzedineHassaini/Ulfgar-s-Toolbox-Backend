package be.tftic.java.ulgarstoolbox.domain.enums;

public enum Ability {

    STRENGTH("STR"),
    DEXTERITY("DEX"),
    CONSTITUTION("CON"),
    INTELLIGENCE("INT"),
    WISDOM("WIS"),
    CHARISMA("CHA");

    public final String shortName;

    Ability(String shortName){
        this.shortName = shortName;
    }

}
