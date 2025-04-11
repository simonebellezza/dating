package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "match")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private Type type;

    // ---------- Relazioni ----------

    // (Doppia) User N:1, N:1
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("matchesAsUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_target_id", referencedColumnName = "id")
    @JsonIgnoreProperties("matchesAsTarget")
    private User userTarget;
}
