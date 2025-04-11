package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.smartworki.dating_app.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDetail {
    @Id
    private Long id;

    @Column(name = "last_online")
    private LocalDateTime lastOnline;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.OFFLINE;

    // ---------- Relazioni ----------

    // User 1:1
    @OneToOne
    @MapsId  // Mappa l'id di User come id di UserDetail
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("userDetail")
    private User user;
}
