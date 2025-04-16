package it.smartworki.dating_app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import it.smartworki.dating_app.dtos.UserRequestDTO;
import it.smartworki.dating_app.dtos.UserResponseDTO;
import it.smartworki.dating_app.dtos.UserResponseMinimalDTO;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

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

    @Operation(summary = "Save all users")
    @PostMapping("/all")
    public List<UserResponseDTO> saveAll(@RequestBody @Valid List<UserRequestDTO> users) {
        return userService.saveAll(users);
    }

    @Operation(summary = "Save user")
    @PostMapping("/")
    public UserResponseDTO save(@RequestBody @Valid UserRequestDTO user) {
        return userService.save(user);
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
}
