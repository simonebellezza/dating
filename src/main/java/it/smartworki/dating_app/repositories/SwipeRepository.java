package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.Swipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Long> {
    // existsByUserIdAndUserTargetId
    boolean existsByUserIdAndUserTargetId(Long userId, Long userTargetId);
}
