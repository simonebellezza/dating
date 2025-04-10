package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "preferences")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pref_genre")
    private Genre prefGenre;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "max_age")
    private Integer maxAge;

    @Column(name = "max_distance")
    private Long maxDistance;

    // --------- Relazioni ----------

    // User 1:1
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("preference")
    private User user;
}
