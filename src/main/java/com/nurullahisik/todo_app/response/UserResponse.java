package com.nurullahisik.todo_app.response;

import com.nurullahisik.todo_app.entity.User;
import lombok.Data;

@Data
public class UserResponse {
    Long id;

    String name;

    String surname;

    String username;


    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
    }
}
