package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.Match;
import it.smartworki.dating_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    boolean existsByUserIdAndUserTargetId(Long userId, Long userTargetId);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END " +
            "FROM Match m WHERE (m.user = :u1 AND m.userTarget = :u2) " +
            "OR (m.user = :u2 AND m.userTarget = :u1)")
    boolean existsByUsers(@Param("u1") User u1, @Param("u2") User u2);
}
