package com.nurullahisik.todo_app.service;

import com.nurullahisik.todo_app.entity.User;
import com.nurullahisik.todo_app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
