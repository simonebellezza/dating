package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "interest_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InterestUser {
    @EmbeddedId
    private InterestUserId id;

    @ManyToOne
    @MapsId("userId")  // Mappa userId di InterestUserId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("interests")
    private User user;

    @ManyToOne
    @MapsId("interestId")  // Mappa interestId di InterestUserId
    @JoinColumn(name = "interest_id", referencedColumnName = "id")
    @JsonIgnoreProperties("users")
    private Interest interest;
}
