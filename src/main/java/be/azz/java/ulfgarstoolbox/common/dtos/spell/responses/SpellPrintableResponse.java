package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetails;
import lombok.Builder;

@Builder
public record SpellPrintableResponse(
        String name,
        String school,
        String schoolComplement,
        String description,
        String savingThrow,
        String castingTime,
        String range,
        String targets,
        String effect,
        String duration,
        String spellResistance,
        String components,
        Integer page,
        String bookName,
        String bookShortName,
        String classOrDomain,
        Integer level
) {

    public static SpellPrintableResponse fromEntity(SpellDetails entity, String classOrDomain, String type){
        return SpellPrintableResponse.builder()
                .name(entity.getName())
                .school(entity.getSchool())
                .schoolComplement(entity.getSchoolComplement())
                .description(entity.getDescription())
                .savingThrow(entity.getSavingThrow())
                .castingTime(entity.getCastingTime())
                .range(entity.getRange())
                .targets(entity.getTargets())
                .effect(entity.getEffect())
                .duration(entity.getDuration())
                .spellResistance(entity.getSpellResistance())
                .components(entity.getComponents())
                .page(entity.getPage())
                .bookName(entity.getBookName())
                .bookShortName(entity.getBookShortName())
                .classOrDomain(classOrDomain)
                .level(getSpellLevel(entity, classOrDomain, type))
                .build();
    }

    private static Integer getSpellLevel(SpellDetails entity, String classOrDomain, String type) {
        String levelsString;
        if (type.equals("class")){
            levelsString = entity.getClassLevels();
        } else if (type.equals("domain")){
            levelsString = entity.getDomainLevels();
        } else {
            throw new RuntimeException("Invalid type: " + type);
        }

        String[] levelPairs = levelsString.split(";");
        for (String levelPair : levelPairs) {
            String[] parts = levelPair.split(":");
            if (parts.length == 2 && parts[0].equals(classOrDomain)) {
                try {
                    return Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid level format for " + classOrDomain);
                }
            }
        }
        throw new RuntimeException("Unable to get spell level for " + classOrDomain + " in " + entity);
    }

}
