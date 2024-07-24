package be.azz.java.ulfgarstoolbox.dal.specifications;

import be.azz.java.ulfgarstoolbox.domain.entities.*;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public interface SpellSpecifications<T> {

    static <T> Specification<T> filterByParams(Map<String, String> params) {
        Specification<T> specification = Specification.where(null);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!entry.getValue().isBlank()) {
                specification = specification.and(filterBy(entry.getKey(), entry.getValue()));
            }
        }

        return specification;
    }

    static <T> Specification<T> filterBy(String key, String value) {
        return (root, query, criteriaBuilder) ->
            switch (key) {

                case "class" -> {
                    Join<SpellClass, CharacterClass> spellClassJoin = root.join("characterClass");
                    yield criteriaBuilder.like(spellClassJoin.get("name"), "%" + value + "%");
                }

                case "domain" -> {
                    Join<SpellDomain, Domain> spellDomainJoin = root.join("domain");
                    yield criteriaBuilder.like(spellDomainJoin.get("name"), "%" + value + "%");
                }

                case "level" ->
                    criteriaBuilder.equal(root.get("level"), value);

                case "school" -> {
                    Join<SpellClass, Spell> spellJoin = root.join("spell");
                    yield criteriaBuilder.equal(spellJoin.get("school"), value);
                }

                case "verbalComponents" -> {
                    Join<SpellClass, Spell> spellJoin = root.join("spell");
                    yield criteriaBuilder.like(spellJoin.get("components"), "%V%");
                }

                case "materialComponents" -> {
                    Join<SpellClass, Spell> spellJoin = root.join("spell");
                    yield criteriaBuilder.like(spellJoin.get("components"), "%M%");
                }

                case "somaticComponents" -> {
                    Join<SpellClass, Spell> spellJoin = root.join("spell");
                    yield criteriaBuilder.like(spellJoin.get("components"), "%G%");
                }

                case "focusComponents" -> {
                    Join<SpellClass, Spell> spellJoin = root.join("spell");
                    yield criteriaBuilder.like(spellJoin.get("components"), "%F%");
                }

                case "divineFocusComponents" -> {
                    Join<SpellClass, Spell> spellJoin = root.join("spell");
                    yield criteriaBuilder.like(spellJoin.get("components"), "%FD%");
                }

                case "experienceComponents" -> {
                    Join<SpellClass, Spell> spellJoin = root.join("spell");
                    yield criteriaBuilder.like(spellJoin.get("components"), "%XP%");
                }



                default -> null;
            };
    }
}
