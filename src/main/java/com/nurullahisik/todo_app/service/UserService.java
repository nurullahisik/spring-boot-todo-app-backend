package com.nurullahisik.todo_app.service;

import com.nurullahisik.todo_app.entity.User;
import com.nurullahisik.todo_app.repository.UserRepository;
import com.nurullahisik.todo_app.request.UserLoginRequest;
import com.nurullahisik.todo_app.request.UserRegisterRequest;
import com.nurullahisik.todo_app.response.UserResponse;
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

    public UserResponse login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null){
            return null;
        }

        if (!user.getPassword().equals(request.getPassword())){
            return null;
        }

        UserResponse userResponse = new UserResponse(user);
        return userResponse;
    }

    public UserResponse register(UserRegisterRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null){
            User newUser = new User();

            newUser.setName(request.getName());
            newUser.setSurname(request.getSurname());
            newUser.setUsername(request.getUsername());
            newUser.setPassword(request.getPassword());
            userRepository.save(newUser);

            UserResponse userResponse = new UserResponse(newUser);
            return userResponse;
        }
        return null;
    }
}
