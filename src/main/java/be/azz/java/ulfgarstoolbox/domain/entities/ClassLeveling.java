package be.azz.java.ulfgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "classeleveling", schema = "dnd35")
public class ClassLeveling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_classe", nullable = false)
    private CharacterClass characterClass;

    @NotNull
    @Column(name = "niveau", nullable = false)
    private Integer level;

    @Size(max = 20)
    @NotNull
    @Column(name = "bba", nullable = false, length = 20)
    private String baseAttackBonus;

    @NotNull
    @Column(name = "reflexes", nullable = false)
    private Integer reflexSavingThrom;

    @NotNull
    @Column(name = "vigueur", nullable = false)
    private Integer fortitudeSavingThrow;

    @NotNull
    @Column(name = "volonte", nullable = false)
    private Integer willSavingThrow;

    @NotNull
    @Column(name = "special", nullable = false)
    private Integer special;

    @NotNull
    @Column(name = "don_supp", nullable = false)
    private Integer additionalFeat;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "don_supp_guerrier", nullable = false)
    private Integer warriorAdditionalFeat;

    @Size(max = 25)
    @Column(name = "deluge_coups", length = 25)
    private String flurryOfBlows;

    @Size(max = 10)
    @Column(name = "degats_mains_nues_p", length = 10)
    private String unarmedDamageP;

    @Size(max = 10)
    @Column(name = "degats_mains_nues_m", length = 10)
    private String unarmedDamageM;

    @ColumnDefault("0")
    @Column(name = "bonus_ca")
    private Integer acBonus;

    @Column(name = "deplacement_accelere")
    private Integer speedBonus;

    @Column(name = "sort_connu_lvl0")
    private Integer knownSpellLvl0;

    @Column(name = "sort_connu_lvl1")
    private Integer knownSpellLvl1;

    @Column(name = "sort_connu_lvl2")
    private Integer knownSpellLvl2;

    @Column(name = "sort_connu_lvl3")
    private Integer knownSpellLvl3;

    @Column(name = "sort_connu_lvl4")
    private Integer knownSpellLvl4;

    @Column(name = "sort_connu_lvl5")
    private Integer knownSpellLvl5;

    @Column(name = "sort_connu_lvl6")
    private Integer knownSpellLvl6;

    @Column(name = "sort_connu_lvl7")
    private Integer knownSpellLvl7;

    @Column(name = "sort_connu_lvl8")
    private Integer knownSpellLvl8;

    @Column(name = "sort_connu_lvl9")
    private Integer knownSpellLvl9;

    @Column(name = "sort_lvl0")
    private Integer spellSlotLvl0;

    @Column(name = "sort_lvl1")
    private Integer spellSlotLvl1;

    @Column(name = "sort_lvl2")
    private Integer spellSlotLvl2;

    @Column(name = "sort_lvl3")
    private Integer spellSlotLvl3;

    @Column(name = "sort_lvl4")
    private Integer spellSlotLvl4;

    @Column(name = "sort_lvl5")
    private Integer spellSlotLvl5;

    @Column(name = "sort_lvl6")
    private Integer spellSlotLvl6;

    @Column(name = "sort_lvl7")
    private Integer spellSlotLvl7;

    @Column(name = "sort_lvl8")
    private Integer spellSlotLvl8;

    @Column(name = "sort_lvl9")
    private Integer spellSlotLvl9;

}