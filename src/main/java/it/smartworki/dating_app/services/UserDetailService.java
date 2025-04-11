package it.smartworki.dating_app.services;

import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.entities.UserDetail;
import it.smartworki.dating_app.exceptions.UserNotFoundException;
import it.smartworki.dating_app.repositories.UserDetailRepository;
import it.smartworki.dating_app.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
    private UserDetailRepository userDetailRepository;
    private UserRepository userRepository;

    @Autowired
    public UserDetailService(UserDetailRepository userDetailRepository, UserRepository userRepository) {
        this.userDetailRepository = userDetailRepository;
        this.userRepository = userRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    // save
    @Transactional
    public UserDetail save(UserDetail userDetail) {
        Long userId = userDetail.getUser().getId();

        // Recupera il User managed
        User managedUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        // Assicura che non esista già un UserDetail
        if (userDetailRepository.existsById(userId)) {
            throw new IllegalStateException("UserDetail already exists for user ID: " + userId);
        }

        // Imposta i riferimenti corretti
        userDetail.setUser(managedUser);
        userDetail.setId(userId);  // mapsId richiede questo
        managedUser.setUserDetail(userDetail); // bidirezionale

        // ⚠️ Questo forza Hibernate a fare un INSERT
        entityManager.persist(userDetail);

        return userDetail;
    }
}
