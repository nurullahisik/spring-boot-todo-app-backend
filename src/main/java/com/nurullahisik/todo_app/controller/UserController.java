package com.nurullahisik.todo_app.controller;

import com.nurullahisik.todo_app.entity.User;
import com.nurullahisik.todo_app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user)
    {

        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserInfo(@PathVariable Long userId)
    {

        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user)
    {

        return null;
    }

}
