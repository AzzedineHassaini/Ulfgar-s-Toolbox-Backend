package be.azz.java.ulfgarstoolbox.dal.specifications;

import be.azz.java.ulfgarstoolbox.domain.entities.*;
import be.azz.java.ulfgarstoolbox.domain.entities.tempTables.SpellDetails;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public interface SpellSpecifications {

    static Specification<SpellDetails> filterByParams(Map<String, String> params) {
        Specification<SpellDetails> specification = Specification.where(null);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!entry.getValue().isBlank()) {
                specification = specification.and(filterBy(entry.getKey(), entry.getValue()));
            }
        }

        return specification;
    }

    static Specification<SpellDetails> filterBy(String key, String value) {
        return (root, query, criteriaBuilder) ->
            switch (key) {

                case "class" -> {
                    criteriaBuilder.like(root.get("classLevels"), "%" + value + "%");
                }

                case "domain" -> {
                    criteriaBuilder.like(root.get("domainLevels"), "%" + value + "%");
                }

                case "level" -> {
                    criteriaBuilder.like(root.get("domainLevels"), "%" + value + "%");
                    criteriaBuilder.or(criteriaBuilder.like(root.get("classLevels"), "%" + value + "%"));
                }

//                case "school" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.equal(spellJoin.get("school"), value);
//                }
//
//                case "verbalComponents" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.like(spellJoin.get("components"), "%V%");
//                }
//
//                case "materialComponents" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.like(spellJoin.get("components"), "%M%");
//                }
//
//                case "somaticComponents" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.like(spellJoin.get("components"), "%G%");
//                }
//
//                case "focusComponents" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.like(spellJoin.get("components"), "%F%");
//                }
//
//                case "divineFocusComponents" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.like(spellJoin.get("components"), "%FD%");
//                }
//
//                case "experienceComponents" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.like(spellJoin.get("components"), "%XP%");
//                }
//
//                case "effect" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.like(spellJoin.get("effect"), "%" + value + "%");
//                }
//
//                case "description" -> {
//                    Join<T, Spell> spellJoin = root.join("spell");
//                    yield criteriaBuilder.like(spellJoin.get("description"), "%" + value + "%");
//                }

                default -> null;
            };
    }
}
