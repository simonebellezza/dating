package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.InterestUser;
import it.smartworki.dating_app.entities.embeddedIds.InterestUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestUserRepository extends JpaRepository<InterestUser, InterestUserId> {
}
