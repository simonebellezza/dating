package it.smartworki.dating_app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.smartworki.dating_app.dtos.LoginRequestDTO;
import it.smartworki.dating_app.dtos.UserRegisterDTO;
import it.smartworki.dating_app.dtos.UserRequestDTO;
import it.smartworki.dating_app.security.AuthResponse;
import it.smartworki.dating_app.security.JWTUtils;
import it.smartworki.dating_app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JWTUtils jwtUtils;
    private UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JWTUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @Operation(summary = "Registrazione utente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utente registrato correttamente"),
            @ApiResponse(responseCode = "400", description = "Credenziali non valide")
    })
    @PostMapping("/register")
    public String register(@Valid @RequestBody UserRegisterDTO request) {
        userService.save(request);
        return "Registrazione avvenuta con successo!";
    }

    @Operation(summary = "Autenticazione utente e generazione token JWT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login riuscito"),
            @ApiResponse(responseCode = "401", description = "Credenziali non valide")
    })
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtils.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setEmail(request.getEmail());
        authResponse.setToken(token);
        return ResponseEntity.ok(authResponse);
    }
}