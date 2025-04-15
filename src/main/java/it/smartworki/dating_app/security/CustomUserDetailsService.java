package it.smartworki.dating_app.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.smartworki.dating_app.entities.Role;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Cerca l'utente nel database tramite email
        User user= userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con email: " +email));

        // Crea e restituisce un oggetto UserDetails con i dati dell'utente
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail()) // Imposta l'email come username
                .password(user.getPassword()) // Imposta la password (che sarà verificata da Spring Security)
                .authorities("USER") // Imposta i ruoli/autorizzazioni dell'utente
                .build();
    }

}
