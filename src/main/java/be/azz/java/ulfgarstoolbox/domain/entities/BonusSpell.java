package be.azz.java.ulfgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "modificateurs", schema = "dnd35")
public class BonusSpell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "valeur_caracteristique", nullable = false)
    private Integer abilityScore;

    @NotNull
    @Column(name = "modificateur", nullable = false)
    private Integer modifier;

    @Column(name = "bonus_sort0")
    private Integer bonusSpellLvl0;

    @Column(name = "bonus_sort1")
    private Integer bonusSpellLvl1;

    @Column(name = "bonus_sort2")
    private Integer bonusSpellLvl2;

    @Column(name = "bonus_sort3")
    private Integer bonusSpellLvl3;

    @Column(name = "bonus_sort4")
    private Integer bonusSpellLvl4;

    @Column(name = "bonus_sort5")
    private Integer bonusSpellLvl5;

    @Column(name = "bonus_sort6")
    private Integer bonusSpellLvl6;

    @Column(name = "bonus_sort7")
    private Integer bonusSpellLvl7;

    @Column(name = "bonus_sort8")
    private Integer bonusSpellLvl8;

    @Column(name = "bonus_sort9")
    private Integer bonusSpellLvl9;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "can_cast", nullable = false)
    private Byte canCast;

}