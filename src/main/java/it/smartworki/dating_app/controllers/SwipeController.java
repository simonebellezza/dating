package it.smartworki.dating_app.controllers;

import it.smartworki.dating_app.dtos.SwipeRequestDTO;
import it.smartworki.dating_app.entities.Swipe;
import it.smartworki.dating_app.services.SwipeService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/swipes")
public class SwipeController {

    @Autowired
    private SwipeService swipeService;

    @PostMapping("/")
    public ResponseEntity<String> swipe(
            @RequestBody SwipeRequestDTO dto // Da validare
    ) {
        swipeService.doSwipe(dto);
        return ResponseEntity.ok("Swipe registrato");
    }
}