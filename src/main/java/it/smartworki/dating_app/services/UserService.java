package it.smartworki.dating_app.services;

import it.smartworki.dating_app.dtos.UserDTO;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.exceptions.UserAlreadyExistsException;
import it.smartworki.dating_app.exceptions.UserNotFoundException;
import it.smartworki.dating_app.mappers.UserMapper;
import it.smartworki.dating_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // findAll
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // findById
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toDTO(user);
    }

    // save
    public UserDTO save(User user) {
        // Verifica che la email non esista già
        if(userRepository.existsByEmail(user.getEmail()))
            throw new UserAlreadyExistsException(user.getEmail());

        userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    // updateById
    public UserDTO updateById(Long id, User user) {
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

        userRepository.save(existingUser);

        return UserMapper.toDTO(existingUser);
    }
}