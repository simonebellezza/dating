package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.smartworki.dating_app.entities.enums.SwipeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "swipes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Swipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private SwipeType type;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // ---------- Relazioni ----------

    // (Doppia) User N:1
    // User che ha fatto lo swipe
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("swipes")
    private User user;

    // User che ha subito lo swipe
    @ManyToOne
    @JoinColumn(name = "user_target_id", referencedColumnName = "id")
    @JsonIgnoreProperties("swipesAsTarget")
    private User userTarget;
}