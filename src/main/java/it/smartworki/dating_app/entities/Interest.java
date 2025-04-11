package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "interests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // ---------- Relazioni ----------

    // InterestUser 1:N
    @OneToMany(mappedBy = "interest")
    @JsonIgnoreProperties("interest")
    private Set<InterestUser> users;
}
