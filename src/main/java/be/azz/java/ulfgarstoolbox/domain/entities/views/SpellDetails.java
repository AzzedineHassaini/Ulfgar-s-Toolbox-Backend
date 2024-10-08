package be.azz.java.ulfgarstoolbox.domain.entities.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@Entity
@Immutable
@Table(name = "vue_spell_details")
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
    private String spellResistance;

    @Column(name = "id_bouquin")
    private Long idRuleBook;

    @Column(name = "page")
    private Integer page;

    @Column(name = "nom_bouquin")
    private String bookName;

    @Column(name = "short_name_bouquin")
    private String bookShortName;

    @Column(name = "cibles")
    private String targets;

    @Column(name = "classes_niveaux", columnDefinition = "TEXT")
    private String classLevels;

    @Column(name = "domaines_niveaux", columnDefinition = "TEXT")
    private String domainLevels;

    @Column(name = "ecole_image")
    private String schoolImage;
}