package be.azz.java.ulfgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity
@Table(name = "bouquin")
@Builder
@AllArgsConstructor
public class RuleBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String name;

    @NotNull
    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "cover")
    private String coverImage;

    @Column(name = "link")
    private String link;

    public RuleBook() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleBook ruleBook = (RuleBook) o;
        return Objects.equals(id, ruleBook.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
