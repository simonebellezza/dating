package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.smartworki.dating_app.entities.enums.SwipeType;
import jakarta.persistence.*;
import lombok.*;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private SwipeType type;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"swipesSent", "swipesReceived", "matchesInitiated", "matchesReceived"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_target_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"swipesSent", "swipesReceived", "matchesInitiated", "matchesReceived"})
    private User userTarget;
}