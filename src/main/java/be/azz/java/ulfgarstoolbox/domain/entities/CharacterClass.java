package be.azz.java.ulfgarstoolbox.domain.entities;

import be.azz.java.ulfgarstoolbox.domain.enums.Ability;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "classe")
public class CharacterClass {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "nom", nullable = false, length = 45, unique = true)
    private String name;

    @NotNull
    @Column(name = "dV", nullable = false)
    private Integer hitDice;

    @NotNull
    @Column(name = "points_competences", nullable = false)
    private Integer skillPoints;

    @Size(max = 15)
    @Column(name = "caracteristique_lanceur_sort", length = 15)
    @Enumerated(EnumType.STRING)
    private Ability spellCasterAbility;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "po_min_lvl1", nullable = false)
    private Integer minimumGoldAtCreation;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "po_max_lvl1", nullable = false)
    private Integer maximumGoldAtCreation;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Size(max = 45)
    @Column(name = "type_magie", length = 45)
    private String magicType;

    @OneToMany (mappedBy = "characterClass")
    private Set<SpellClass> spellClass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterClass that = (CharacterClass) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}