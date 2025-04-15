package it.smartworki.dating_app.services;

import it.smartworki.dating_app.dtos.SwipeRequestDTO;
import it.smartworki.dating_app.entities.Match;
import it.smartworki.dating_app.entities.Swipe;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.entities.enums.SwipeType;
import it.smartworki.dating_app.exceptions.notFound.UserNotFoundException;
import it.smartworki.dating_app.repositories.MatchRepository;
import it.smartworki.dating_app.repositories.SwipeRepository;
import it.smartworki.dating_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SwipeService {

    @Autowired
    private SwipeRepository swipeRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private UserRepository userRepository;

    // Definire la transazione
    public void doSwipe(SwipeRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(dto.getUserId()));

        User target = userRepository.findById(dto.getTargetId())
                .orElseThrow(() -> new UserNotFoundException(dto.getTargetId()));

        // Se swipe già esiste, ignora
        if (swipeRepository.existsByUserIdAndUserTargetId(user.getId(), target.getId())) {
            return;
        }

        // Creare lo swipe (con tipo corretto)
        SwipeType swipeType = SwipeType.valueOf(dto.getType().toUpperCase());
        Swipe swipe = new Swipe();
        swipe.setUser(user);
        swipe.setUserTarget(target);
        swipe.setType(swipeType);
        swipe.setTimestamp(java.time.LocalDateTime.now());
        swipeRepository.save(swipe);

        // Solo se swipe è LIKE o SUPER_LIKE, verificare reciprocità
        if (swipeType != SwipeType.PASS) {
            Optional<Swipe> reverseSwipe = swipeRepository
                    .findByUserAndUserTargetAndTypeIn(
                            target,
                            user,
                            List.of(SwipeType.LIKE, SwipeType.SUPER_LIKE)
                    );

            if (reverseSwipe.isPresent()) {
                // Verifica che il match non esista già (in entrambi gli ordini)
                boolean matchExists = matchRepository.existsByUsers(user, target);
                if (!matchExists) {

                    User first = user.getId() < target.getId() ? user : target;
                    User second = user.getId() < target.getId() ? target : user;

                    Match match = new Match();
                    match.setUser(first);
                    match.setUserTarget(second);
                    match.setTimestamp(LocalDateTime.now());
                    matchRepository.save(match);
                }
            }
        }
    }
}