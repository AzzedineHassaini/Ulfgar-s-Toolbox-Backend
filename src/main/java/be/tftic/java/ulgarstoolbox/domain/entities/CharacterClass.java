package be.tftic.java.ulgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;

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
    @Column(name = "pointsCompetences", nullable = false)
    private Integer skillPoints;

    @Size(max = 15)
    @Column(name = "caracteristiqueLanceurSort", length = 15)
    private String spellCasterCharacteristic;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "poMinLvl1", nullable = false)
    private Integer minimumGoldAtCreation;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "poMaxLvl1", nullable = false)
    private Integer maximumGoldAtCreation;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Size(max = 45)
    @Column(name = "typeMagie", length = 45)
    private String magicType;

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