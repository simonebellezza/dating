package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "type", nullable = false, unique = true)
    private String type;

    // ---------- Relazioni ----------

    // GenreUser 1:N
    @OneToMany(mappedBy = "genre")
    @JsonIgnoreProperties("genre")
    private Set<GenreUser> users;

    // GenrePreference 1:N
    @ManyToMany(mappedBy = "genres")
    @JsonIgnoreProperties("genres")
    private Set<Preference> preferences;
}
