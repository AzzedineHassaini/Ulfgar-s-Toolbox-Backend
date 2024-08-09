package be.azz.java.ulfgarstoolbox.dal.specifications;

import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellHistory;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Map;

public interface SpellHistorySpecification {

    static Specification<SpellHistory> filterByParams(Map<String, String> params) {
        Specification<SpellHistory> specification = Specification.where(null);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!entry.getValue().isBlank()) {
                specification = specification.and(filterBy(entry.getKey(), entry.getValue()));
            }
        }

        return specification;
    }

    static Specification<SpellHistory> filterBy(String key, String value) {
        return (root, query, criteriaBuilder) ->
                switch (key) {

                    case "user" ->
                            criteriaBuilder.equal(criteriaBuilder.lower(root.get("user")), value.toLowerCase());

                    case "action" ->
                            criteriaBuilder.equal(criteriaBuilder.lower(root.get("action")), value.toLowerCase());

                    case "oldValue" ->
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("oldValue")), "%" + value.toLowerCase() + "%");

                    case "newValue" ->
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("newValue")), "%" + value.toLowerCase() + "%");

                    case "dateFrom" -> { // Format : 2023-01-01T00:00:00Z
                        try {
                            Instant fromDate = Instant.parse(value);
                            yield criteriaBuilder.greaterThanOrEqualTo(root.get("date"), fromDate);
                        } catch (DateTimeParseException e) {
                            yield null;
                        }
                    }
                    case "dateTo" -> { // Format : 2023-01-01T00:00:00Z
                        try {
                            Instant toDate = Instant.parse(value);
                            yield criteriaBuilder.lessThanOrEqualTo(root.get("date"), toDate);
                        } catch (DateTimeParseException e) {
                            yield null;
                        }
                    }

                    default -> null;
                };
    }
}
