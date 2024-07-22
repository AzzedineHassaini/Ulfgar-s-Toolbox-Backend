package be.tftic.java.ulgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sortclasse")
public class SpellClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_sort", nullable = false)
    private Spell spell;

    @ManyToOne
    @JoinColumn(name = "id_classe", nullable = false)
    private CharacterClass characterClass;

    @NotNull
    @Column(name = "niveau", nullable = false)
    private Integer level;

}