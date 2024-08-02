package be.azz.java.ulfgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "domaine")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "domaine",unique = true, nullable = false)
    private String name;

    @Lob
    @Column(name = "pouvoir",columnDefinition = "TEXT")
    private String power;

    @OneToMany (mappedBy = "domain")
    private Set<SpellDomain> spellDomains;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain = (Domain) o;
        return Objects.equals(name, domain.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}