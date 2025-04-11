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
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    // saveAll
    @PostMapping("/all")
    public List<User> saveAll(@RequestBody List<User> users) {
        return userService.saveAll(users);
    }

    // save
    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
