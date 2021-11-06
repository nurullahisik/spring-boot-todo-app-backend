package com.nurullahisik.todo_app.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    String name;

    String surname;

    String username;

    String password;
}
