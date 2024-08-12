package be.azz.java.ulfgarstoolbox.domain.entities.views;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.time.Instant;

@Getter
@Entity
@Immutable
@Table(name = "vue_historique_sorts")
public class SpellHistory {
    @Id
    @NotNull
    @Column(name = "id_audit", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "nom_sort")
    private String spellName;

    @NotNull
    @Lob
    @Column(name = "action", nullable = false)
    private String action;

    @NotNull
    @Lob
    @Column(name = "table_modifiee", nullable = false)
    private String updatedTable;

    @Size(max = 255)
    @Column(name = "champ_modifie")
    private String updatedField;

    @Lob
    @Column(name = "ancienne_valeur")
    private String oldValue;

    @Lob
    @Column(name = "nouvelle_valeur")
    private String newValue;

    @Column(name = "date_modification")
    private Instant date;

    @Size(max = 255)
    @Column(name = "utilisateur")
    private String user;

}