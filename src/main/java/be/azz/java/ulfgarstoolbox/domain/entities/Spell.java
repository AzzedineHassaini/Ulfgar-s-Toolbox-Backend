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

    @Column(name = "description")
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

    @OneToMany (mappedBy = "spell")
    private Set<SpellClass> spellClass;

    @OneToMany (mappedBy = "spell")
    private Set<SpellDomain> spellDomains;

    @ManyToOne
    @JoinColumn(name = "id_bouquin", nullable = false)
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