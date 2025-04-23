package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.Swipe;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.entities.enums.SwipeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Long> {

    // Verifica l'esistenza di uno swipe tra due utenti
    boolean existsByUserIdAndUserTargetId(Long userId, Long targetId);

    Optional<Swipe> findByUserAndUserTargetAndTypeIn(User user, User target, List<SwipeType> types);
}
