package it.smartworki.dating_app.controllers;

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
    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    // findById
    @GetMapping("/id/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    // findByEmail
    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    // existsByUser
    @GetMapping("/exists")
    public boolean existsByEmail(@RequestParam String email) {
        return userService.existsByEmail(email);
    }

    // updateById
    @PutMapping("/{id}")
    public User updateById(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateById(id, user);
    }
}
