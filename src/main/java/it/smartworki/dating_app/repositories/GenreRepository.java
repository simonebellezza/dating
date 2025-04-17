package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Short> {
    // existsByType
    boolean existsByType(String type);

    // existsByTypeIn
    boolean existsByTypeIn(List<String> types);

    List<Genre> findByTypeIn(Collection<String> types);
}
