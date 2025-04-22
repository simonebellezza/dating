package it.smartworki.dating_app.repositories;

import it.smartworki.dating_app.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Qui puoi aggiungere query personalizzate, ad esempio per recuperare tutti i messaggi tra due utenti
}
