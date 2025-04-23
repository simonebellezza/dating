package it.smartworki.dating_app.controllers;

import it.smartworki.dating_app.dtos.SwipeDTO;
import it.smartworki.dating_app.services.SwipeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/swipes")
public class SwipeController {

    private final SwipeService swipeService;

    public SwipeController(SwipeService swipeService) {
        this.swipeService = swipeService;
    }

    @GetMapping
    public ResponseEntity<Set<SwipeDTO>> getAllSwipes(
    ) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Set<SwipeDTO> swipes = swipeService.getAllSwipes(email);
        return ResponseEntity.ok(swipes);
    }

    @PostMapping()
    public ResponseEntity<String> swipe(
            @Valid @RequestBody SwipeDTO dto
    ) {
        swipeService.doSwipe(dto);
        return ResponseEntity.ok("Hai swipato!");
    }
}