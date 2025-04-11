package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // findByEmail
    Optional<User> findByEmail(String email);

    // existsByEmail
    boolean existsByEmail(String email);
}
