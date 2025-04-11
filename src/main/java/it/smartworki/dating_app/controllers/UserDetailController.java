package it.smartworki.dating_app.controllers;

import it.smartworki.dating_app.entities.UserDetail;
import it.smartworki.dating_app.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/details")
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    // save
    @PostMapping("/")
    public UserDetail save(@RequestBody UserDetail userDetail) {
        return userDetailService.save(userDetail);
    }
}
