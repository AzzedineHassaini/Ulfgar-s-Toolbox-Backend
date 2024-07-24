package be.tftic.java.ulfgarstoolbox.dal.specifications;

import be.tftic.java.ulfgarstoolbox.domain.entities.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public interface DomainSpecification {

    static Specification<Domain> filterByParams(Map<String, String> params) {
        Specification<Domain> specification = Specification.where(null);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!entry.getValue().isBlank()) {
                specification = specification.and(filterBy(entry.getKey(), entry.getValue()));
            }
        }

        return specification;
    }

    static Specification<Domain> filterBy(String key, String value) {
        return (root, query, criteriaBuilder) ->
                switch (key) {

                    case "name" ->
                            criteriaBuilder.like(root.get("name"), "%" + value + "%");

                    case "power" ->
                            criteriaBuilder.like(root.get("power"), "%" + value + "%");


                    default -> null;
                };
    }

}
