package it.smartworki.dating_app.services;

import it.smartworki.dating_app.dtos.SwipeDTO;
import it.smartworki.dating_app.entities.Match;
import it.smartworki.dating_app.entities.Swipe;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.entities.enums.SwipeType;
import it.smartworki.dating_app.exceptions.notFound.UserNotFoundException;
import it.smartworki.dating_app.mappers.SwipeMapper;
import it.smartworki.dating_app.repositories.MatchRepository;
import it.smartworki.dating_app.repositories.SwipeRepository;
import it.smartworki.dating_app.repositories.UserRepository;
import it.smartworki.dating_app.security.JWTUtils;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SwipeService {

    private final SwipeRepository swipeRepository;
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;
    private final JWTUtils jwt;

    public SwipeService(
            SwipeRepository swipeRepository,
            MatchRepository matchRepository,
            UserRepository userRepository,
            JWTUtils jwt
    ) {
        this.swipeRepository = swipeRepository;
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
        this.jwt = jwt;
    }

    public Set<SwipeDTO> getAllSwipes(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getSwipesSent()
                .stream()
                .map(SwipeMapper::toDTO)
                .collect(Collectors.toSet()); // Converti in Set
    }

    @Transactional
    public void doSwipe(SwipeDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(dto.getUserId()));

        User target = userRepository.findById(dto.getTargetId())
                .orElseThrow(() -> new UserNotFoundException(dto.getTargetId()));

        // Controlla se l'utente è lo stesso

        if (user.getId().equals(target.getId())) {
            throw new IllegalArgumentException("Non puoi swipare te stesso");
        }

        /// Se l'utente ha già uno swipe, aggiorna il tipo
        if (swipeRepository.existsByUserIdAndUserTargetId(user.getId(), target.getId())) {
            SwipeType swipeType = SwipeType.valueOf(dto.getType().toUpperCase());
            Swipe swipe = swipeRepository.findByUserAndUserTargetAndTypeIn(
                    user,
                    target,
                    List.of(SwipeType.LIKE, SwipeType.SUPER_LIKE, SwipeType.PASS)
            ).orElseThrow(() -> new RuntimeException("Swipe not found"));

            swipe.setType(swipeType);
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