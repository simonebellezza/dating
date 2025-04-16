package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.Check;

import java.util.Set;

@Entity
@Table(name = "preferences")
@Check(constraints = "max_age > min_age")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Preference {
    @Id
    private Long id;

    @Column(name = "min_age", nullable = false)
    @Min(18)
    @Max(150)
    private Integer minAge;

    @Column(name = "max_age", nullable = false)
    @Min(18)
    @Max(150)
    private Integer maxAge;

    @Column(name = "distance", nullable = false)
    @Min(1)
    @Max(500)
    private Long distance = 50l;

    // --------- Relazioni ----------

    // User 1:1
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("preference")
    private User user;

    // GenrePreference 1:N
    @ManyToMany
    @JoinTable(name = "genre_preference",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "preference_id")
    )
    @JsonIgnoreProperties("preference")
    private Set<Genre> genres;
}
