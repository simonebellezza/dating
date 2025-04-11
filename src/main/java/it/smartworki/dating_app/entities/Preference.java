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
    private Long id;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "max_age")
    private Integer maxAge;

    @Column(name = "distance")
    private Long distance;

    // --------- Relazioni ----------

    // User 1:1
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("preference")
    private User user;
}
