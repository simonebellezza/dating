package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // ---------- Relazioni ----------

    // (Doppia) User N:1
    // User che ha fatto il match
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("matches")
    private User user;

    @ManyToOne
    // User che ha subito il match
    @JoinColumn(name = "user_target_id", referencedColumnName = "id")
    @JsonIgnoreProperties("matchesAsTarget")
    private User userTarget;
}
