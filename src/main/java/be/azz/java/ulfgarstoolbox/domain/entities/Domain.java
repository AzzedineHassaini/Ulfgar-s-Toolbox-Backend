package be.azz.java.ulfgarstoolbox.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "domaine")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "domaine",unique = true, nullable = false)
    private String name;

    @Lob
    @Column(name = "pouvoir",columnDefinition = "TEXT")
    private String power;

    @OneToMany (mappedBy = "domain")
    private Set<SpellDomain> spellDomains;

}