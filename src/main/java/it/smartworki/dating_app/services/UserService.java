package it.smartworki.dating_app.services;

import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.exceptions.UserNotFoundException;
import it.smartworki.dating_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // findAll
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // findById
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // saveAll
    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    // save
    public User save(User user) {
        return userRepository.save(user);
    }
}
