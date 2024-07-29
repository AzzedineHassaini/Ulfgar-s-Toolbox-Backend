package be.azz.java.ulfgarstoolbox.domain.entities.tempTables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TempSortDetails")  // Nom de la table temporaire créée par la procédure stockée
public class SpellDetails {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String name;

    @Column(name = "ecole")
    private String school;

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
    private String spellResistance;

    @Column(name = "cibles")
    private String targets;

    @Column(name = "classes_niveaux")
    private String classLevels;

    @Column(name = "domaines_niveaux")
    private String domainLevels;
}