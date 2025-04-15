package it.smartworki.dating_app.services;

import it.smartworki.dating_app.dtos.UserRequestDTO;
import it.smartworki.dating_app.dtos.UserResponseDTO;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.exceptions.alreadyExists.UserAlreadyExistsException;
import it.smartworki.dating_app.exceptions.notFound.UserNotFoundException;
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
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // findById
    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toDTO(user);
    }

    // saveAll
    public List<UserResponseDTO> saveAll(List<UserRequestDTO> users) {
        // Verifica che le email non esistano già
        List<String> emails = users.stream()
                .map(UserRequestDTO::getEmail)
                .collect(Collectors.toList());

        if(userRepository.existsByEmailIn(emails))
            throw new UserAlreadyExistsException(emails);

        // Users veri e propri da salvare nel db
        List<User> newUsers = users.stream()
                        .map(UserMapper::toEntity)
                        .collect(Collectors.toList());

        userRepository.saveAll(newUsers);

        // Mappo gli utenti salvati in UserResponseDTO
        return newUsers.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // save
    public UserResponseDTO save(UserRequestDTO user) {
        // Verifica che la email non esista già
        if(userRepository.existsByEmail(user.getEmail()))
            throw new UserAlreadyExistsException(user.getEmail());

        User newUser = UserMapper.toEntity(user);
        userRepository.save(newUser);

        return UserMapper.toDTO(newUser);
    }

    // updateById
    public UserResponseDTO updateById(Long id, UserRequestDTO user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // Aggiorno campi non nulli
        if(!user.getName().equals(existingUser.getName()))
            existingUser.setName(user.getName());

        if(!user.getEmail().equals(existingUser.getEmail())) {
            // Verifica che la email non esista già
            if(userRepository.existsByEmail(user.getEmail()))
                throw new UserAlreadyExistsException(user.getEmail());

            existingUser.setEmail(user.getEmail());
        }

        if(!user.getPassword().equals(existingUser.getPassword()))
            // Hash della password
            existingUser.setPassword(user.getPassword());

        if(!user.getBirthday().equals(existingUser.getBirthday()))
            existingUser.setBirthday(user.getBirthday());

        if(user.getBio() != null && !user.getBio().equals(existingUser.getBio()))
            existingUser.setBio(user.getBio());

        userRepository.save(existingUser);

        return UserMapper.toDTO(existingUser);
    }

    // deleteAll
    public void deleteAll() {
        userRepository.deleteAll();
    }
}