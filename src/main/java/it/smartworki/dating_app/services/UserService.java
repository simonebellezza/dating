package it.smartworki.dating_app.services;

import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.exceptions.UserAlreadyExistsException;
import it.smartworki.dating_app.exceptions.UserNotFoundException;
import it.smartworki.dating_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    // findByEmail
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    // existsByEmail
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // save
    public User save(User user) {
        // Verifica che la email non esista già
        if(userRepository.existsByEmail(user.getEmail()))
            throw new UserAlreadyExistsException(user.getEmail());

        return userRepository.save(user);
    }

    // updateById
    public User updateById(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // Aggiorno campi non nulli
        if(user.getName() != null)
            existingUser.setName(user.getName());

        if(user.getEmail() != null && !user.getEmail().equals(existingUser.getEmail())) {
            // Verifica che la email non esista già
            if(userRepository.existsByEmail(user.getEmail()))
                throw new UserAlreadyExistsException(user.getEmail());

            existingUser.setEmail(user.getEmail());
        }

        if(user.getPassword() != null)
            // Hash della password
            existingUser.setPassword(user.getPassword());

        if(user.getBirthday() != null)
            existingUser.setBirthday(user.getBirthday());

        if(user.getBio() != null)
            existingUser.setBio(user.getBio());

        if(user.getAccountType() != null)
            existingUser.setAccountType(user.getAccountType());

        if(user.getRegistrationDate() != null)
            existingUser.setRegistrationDate(user.getRegistrationDate());

        return userRepository.save(existingUser);
    }

    // deleteById
    public User deleteById(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.deleteById(id);
        return existingUser;
    }
}