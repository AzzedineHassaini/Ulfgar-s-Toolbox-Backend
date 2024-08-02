package be.azz.java.ulfgarstoolbox.common.dtos.ruleBook;

public record RuleBookResponse(
        Long id,
        String name,
        String shortName,
        String coverImage,
        String link
) {
}
