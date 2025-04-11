package it.smartworki.dating_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.smartworki.dating_app.entities.embeddedIds.GenreUserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "genre_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenreUser {
    @EmbeddedId
    private GenreUserId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("genres")
    private User user;

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("users")
    private Genre genre;
}
