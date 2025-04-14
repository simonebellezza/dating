package it.smartworki.dating_app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.repositories.UserRepository;

/**
 * Controller per gestire le operazioni di autenticazione (login e registrazione).
 */
@RestController // Indica che questa classe è un controller REST
@RequestMapping("/auth") // Tutti i metodi di questo controller sono sotto il percorso /auth
public class AuthController {

    @Autowired // Inietta l'AuthenticationManager configurato in SecurityConfig
    private AuthenticationManager authenticationManager;
    
    @Autowired // Inietta l'utility JWT
    private JWTUtils jwtUtils;
    
    @Autowired // Inietta il repository degli utenti
    private UserRepository userRepository;
    
    @Autowired // Inietta l'encoder per le password
    private PasswordEncoder encoder;
    
  

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("L'utente esiste già!");
        }
        String hashedPwd = encoder.encode(request.getPassword());
       User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(hashedPwd);
        user.setBirthday(request.getBirthday());
        userRepository.save(user);
        return "Registrazione avvenuta con successo!";
    }
}
