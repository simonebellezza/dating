package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.GenreUser;
import it.smartworki.dating_app.entities.embeddedIds.GenreUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreUserRepository extends JpaRepository<GenreUser, GenreUserId> {
}
