package it.smartworki.dating_app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import it.smartworki.dating_app.dtos.UserRequestDTO;
import it.smartworki.dating_app.dtos.UserResponseDTO;
import it.smartworki.dating_app.dtos.UserResponseMinimalDTO;
import it.smartworki.dating_app.dtos.DeviceTokenRequestDTO;
import it.smartworki.dating_app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Find myself")
    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> findMe(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserResponseDTO userResponseDTO = userService.findMe(email);
        return ResponseEntity.ok(userResponseDTO);
    }

    @Operation(summary = "Find user by token or redirect to /me")
    @GetMapping("/user/{id}")
    public ResponseEntity<?> findByToken(@PathVariable long id) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserResponseDTO user = userService.findByToken(email, id);

        // Se l'utente autenticato corrisponde all'utente richiesto, reindirizza a /me
        if (user.getId() == id) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/api/users/me")
                    .build();
        }

        // Altrimenti restituisci i dati dell'utente richiesto
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Find all users")
    @GetMapping("/")
    public List<UserResponseMinimalDTO> findAll() {
        return userService.findAll();
    }

    @Operation(summary = "Find user by ID")
    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @Operation(summary = "Update user by ID")
    @PutMapping("/{id}")
    public UserResponseDTO updateById(@PathVariable("id") Long id, @RequestBody @Valid UserRequestDTO user) {
        return userService.updateById(id, user);
    }

    @Operation(summary = "Delete user by ID")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @Operation(summary = "Salva il deviceToken dell’utente autenticato")
    @PostMapping("/device-token")
    public ResponseEntity<Void> saveDeviceToken(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody @Valid DeviceTokenRequestDTO dto
    ) {
        String token = authHeader.replace("Bearer ", "");
        System.out.println("JWT Token from request: " + token);
        String deviceToken = dto.fmcToken();



        System.out.println("Token FCM ricevuto: " + deviceToken);
        userService.saveDeviceToken(token, dto.fmcToken());
        return ResponseEntity.ok().build();
    }
}
