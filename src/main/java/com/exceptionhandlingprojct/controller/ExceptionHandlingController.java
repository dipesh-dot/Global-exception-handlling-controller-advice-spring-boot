package com.exceptionhandlingprojct.controller;


import com.exceptionhandlingprojct.entity.User;
import com.exceptionhandlingprojct.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/exception-handling")
public class ExceptionHandlingController {

    private final UserService userService;

    public ExceptionHandlingController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok().body(userService.create(user));
    }

    @GetMapping("/all")
    ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }


    @GetMapping("/{id}")
    ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getById(id));
    }

}
