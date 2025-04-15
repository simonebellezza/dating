package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
    // existsByName
    boolean existsByName(String name);

    // existsByNameIn
    boolean existsByNameIn(List<String> names);
}