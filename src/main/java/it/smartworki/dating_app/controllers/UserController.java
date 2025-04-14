package it.smartworki.dating_app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import it.smartworki.dating_app.dtos.UserDTO;
import it.smartworki.dating_app.entities.User;
import it.smartworki.dating_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // findAll
    @Operation(summary = "Find all users")
    @GetMapping("/")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    // findById
    @Operation(summary = "Find user by ID")
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    // updateById
    @Operation(summary = "Update user by ID")
    @PutMapping("/{id}")
    public UserDTO updateById(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateById(id, user);
    }
}
