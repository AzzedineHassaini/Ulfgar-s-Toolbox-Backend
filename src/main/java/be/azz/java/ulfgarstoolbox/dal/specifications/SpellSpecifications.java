package be.azz.java.ulfgarstoolbox.dal.specifications;

import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SpellSpecifications {

    static Specification<SpellDetails> filterByParams(Map<String, String> params) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (!entry.getValue().isBlank()) {
                    Predicate predicate = filterBy(entry.getKey(), entry.getValue(), root, criteriaBuilder);
                    if (predicate != null) {
                        predicates.add(predicate);
                    }
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    static Predicate filterBy(String key, String value, Root<SpellDetails> root, CriteriaBuilder criteriaBuilder) {
        return switch (key) {
            case "class" -> {
                String[] classes = value.split(",");
                List<Predicate> predicates = new ArrayList<>();
                for (String cls : classes) {
                    predicates.add(criteriaBuilder.like(root.get("classLevels"), "%" + cls.trim() + ":%"));
                }
                yield criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }
            case "domain" -> {
                String[] domains = value.split(",");
                List<Predicate> predicates = new ArrayList<>();
                for (String domain : domains) {
                    predicates.add(criteriaBuilder.like(root.get("domainLevels"), "%" + domain.trim() + ":%"));
                }
                yield criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }
            case "minLevel", "maxLevel" -> {
                int minLevel = key.equals("minLevel") ? Integer.parseInt(value) : 0;
                int maxLevel = key.equals("maxLevel") ? Integer.parseInt(value) : 9;
                List<Predicate> predicates = new ArrayList<>();
                for (int i = minLevel; i <= maxLevel; i++) {
                    String levelPattern = ":" + i + ";";
                    String endLevelPattern = ":" + i;
                    predicates.add(criteriaBuilder.like(root.get("classLevels"), "%" + levelPattern + "%"));
                    predicates.add(criteriaBuilder.like(root.get("classLevels"), "%" + endLevelPattern));
                    predicates.add(criteriaBuilder.like(root.get("domainLevels"), "%" + levelPattern + "%"));
                    predicates.add(criteriaBuilder.like(root.get("domainLevels"), "%" + endLevelPattern));
                }
                yield criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }
            case "name" -> criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + value.toLowerCase() + "%");
            case "school" -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("school")), value.toLowerCase());
            case "description" -> criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + value.toLowerCase() + "%");
            case "effect" -> criteriaBuilder.like(criteriaBuilder.lower(root.get("effect")), "%" + value.toLowerCase() + "%");
            case "verbalComponents" -> criteriaBuilder.like(criteriaBuilder.lower(root.get("components")), "%v%");
            case "materialComponents" -> criteriaBuilder.like(criteriaBuilder.lower(root.get("components")), "%m%");
            case "somaticComponents" -> criteriaBuilder.like(criteriaBuilder.lower(root.get("components")), "%g%");
            case "focusComponents" -> criteriaBuilder.like(criteriaBuilder.lower(root.get("components")), "%f%");
            case "experienceComponents" -> criteriaBuilder.like(criteriaBuilder.lower(root.get("components")), "%px%");

            default -> null;
        };
    }
}
