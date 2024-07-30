package be.azz.java.ulfgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sort")
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "nom", nullable = false)
    private String name;

    @Column(name = "ecole")
    private String school;

    @Size(max = 255)
    @Column(name = "complement_ecole")
    private String schoolComplement;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "sauvegarde")
    private String savingThrow;

    @Column(name = "composantes")
    private String components;

    @Column(name = "temps_incantation")
    private String castingTime;

    @Column(name = "portee")
    private String range;

    @Column(name = "effet")
    private String effect;

    @Column(name = "duree")
    private String duration;

    @Column(name = "resistance_magie")
    private String magicResistance;

    @Column(name = "cibles")
    private String targets;

    @OneToMany (mappedBy = "spell", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SpellClass> spellClass;

    @OneToMany (mappedBy = "spell", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SpellDomain> spellDomains;

    @ManyToOne
    @JoinColumn(name = "id_bouquin")
    private RuleBook ruleBook;

    @Column(name = "page")
    private Integer page;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return Objects.equals(id, spell.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}