package be.azz.java.ulfgarstoolbox.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sortecoles")
public class SpellSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ecole")
    private String name;

    @Column(name = "titre")
    private String title;

    @Column(name = "peut_etre_interdite")
    private boolean canBeForbidden;

    @Column(name = "nb_ecole_intedite")
    private Integer numberForbiddenSchool;

    @Column(name = "image")
    private String image;
}
