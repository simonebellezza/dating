package it.smartworki.dating_app.services;

import it.smartworki.dating_app.dtos.UserRegisterDTO;
import it.smartworki.dating_app.dtos.UserRequestDTO;
import it.smartworki.dating_app.dtos.UserResponseDTO;
import it.smartworki.dating_app.dtos.UserResponseMinimalDTO;
import it.smartworki.dating_app.entities.Genre;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.exceptions.alreadyExists.UserAlreadyExistsException;
import it.smartworki.dating_app.exceptions.notFound.UserNotFoundException;
import it.smartworki.dating_app.mappers.UserMapper;
import it.smartworki.dating_app.repositories.GenreRepository;
import it.smartworki.dating_app.repositories.UserRepository;
import it.smartworki.dating_app.security.JWTUtils;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwts;
    private final GenreRepository genreRepository;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JWTUtils jwts,
            GenreRepository genreRepository
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwts = jwts;
        this.genreRepository = genreRepository;
    }

    public List<UserResponseMinimalDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toMinimalDTO)
                .collect(Collectors.toList());
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toDTO(user);
    }

    public UserResponseDTO findMe(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));;
                return UserMapper.toDTO(user);
    }

    public UserResponseDTO findByToken(String email, long id) {
        User userFounded = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));

        if (user.getId() == id) {
            // Restituisci l'utente autenticato per indicare che deve essere reindirizzato
            return UserMapper.toDTO(user);
        }

        // Restituisci l'utente richiesto
        return UserMapper.toDTO(userFounded);
    }

    @Transactional
    public UserResponseDTO save(UserRegisterDTO userRegisterDTO) {
        if (userRepository.existsByEmail(userRegisterDTO.getEmail()))
            throw new UserAlreadyExistsException(userRegisterDTO.getEmail());

        User user = UserMapper.toEntity(userRegisterDTO);

        // Codifica della password
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        user.setRegistrationDate(LocalDate.now());

        List<Genre> genres = genreRepository.findByTypeIn(userRegisterDTO.getGenres());

        if (genres.size() != userRegisterDTO.getGenres().size()) {
            Set<String> found = genres.stream().map(Genre::getType).collect(Collectors.toSet());
            Set<String> missing = new HashSet<>(userRegisterDTO.getGenres());
            missing.removeAll(found);
            throw new IllegalArgumentException("Genere inesistente: " + missing);
        }

        user.setGenres(new HashSet<>(genres));

        userRepository.saveAndFlush(user);

        return UserMapper.toDTO(user);
    }

    public UserResponseDTO updateById(Long id, UserRequestDTO user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // Aggiorno campi non nulli
        if (!user.getName().equals(existingUser.getName()))
            existingUser.setName(user.getName());

        if (!user.getEmail().equals(existingUser.getEmail())) {
            // Verifica che la email non esista già
            if (userRepository.existsByEmail(user.getEmail()))
                throw new UserAlreadyExistsException(user.getEmail());

            existingUser.setEmail(user.getEmail());
        }

        // Se viene passata una nuova password, la codifico e la setto
        if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        if (!user.getBirthday().equals(existingUser.getBirthday()))
            existingUser.setBirthday(user.getBirthday());

        if (user.getBio() != null && !user.getBio().equals(existingUser.getBio()))
            existingUser.setBio(user.getBio());

        userRepository.save(existingUser);

        return UserMapper.toDTO(existingUser);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void saveDeviceToken(String jwt, String deviceToken) {
        String email = jwts.getUsername(jwt);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));

        user.setFcmToken(deviceToken);
        userRepository.save(user);
    }

    public User findEntityByToken(String jwt) {
        String email = jwts.getUsername(jwt);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));

        return user;
    }

    public User findEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));
    }
}