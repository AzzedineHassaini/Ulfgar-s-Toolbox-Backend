package be.tftic.java.ulgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "sortdomaine")
public class SpellDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @Column(name = "id_domaine", nullable = false)
    private Domain domain;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "niveau", nullable = false)
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "id_sort", nullable = false)
    private Spell spell;

}