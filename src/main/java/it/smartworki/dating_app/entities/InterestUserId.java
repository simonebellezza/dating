package it.smartworki.dating_app.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class InterestUserId implements Serializable {
    private Long userId;
    private Long interestId;
}
