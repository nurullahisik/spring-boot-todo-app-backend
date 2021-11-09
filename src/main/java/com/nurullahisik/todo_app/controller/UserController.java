package com.nurullahisik.todo_app.controller;

import com.nurullahisik.todo_app.entity.User;
import com.nurullahisik.todo_app.request.UserLoginRequest;
import com.nurullahisik.todo_app.request.UserRegisterRequest;
import com.nurullahisik.todo_app.response.UserResponse;
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
    public ResponseEntity<UserResponse> login(UserLoginRequest request)
    {
        return ResponseEntity.ok(userService.login(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserInfo(@PathVariable Long userId)
    {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(UserRegisterRequest request)
    {
        return ResponseEntity.ok(userService.register(request));
    }

}
