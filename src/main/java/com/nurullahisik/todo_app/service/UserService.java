package com.nurullahisik.todo_app.service;

import com.nurullahisik.todo_app.entity.User;
import com.nurullahisik.todo_app.repository.UserRepository;
import com.nurullahisik.todo_app.request.UserLoginRequest;
import com.nurullahisik.todo_app.request.UserRegisterRequest;
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

    public User login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null){
            return null;
        }

        if (!user.getPassword().equals(request.getPassword())){
            return null;
        }

        return user;
    }

    public User register(UserRegisterRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null){
            User newUser = new User();

            newUser.setName(request.getName());
            newUser.setSurname(request.getSurname());
            newUser.setUsername(request.getUsername());
            newUser.setPassword(request.getPassword());

            return userRepository.save(newUser);
        }
        return null;
    }
}
