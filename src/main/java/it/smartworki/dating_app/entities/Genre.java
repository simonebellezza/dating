package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "type", nullable = false, unique = true)
    private String type;

    // ---------- Relazioni ----------

    @ManyToMany(mappedBy = "genres")
    @JsonIgnoreProperties("genres")
    private Set<User> users;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnoreProperties("genres")
    private Set<Preference> preferences;
}
