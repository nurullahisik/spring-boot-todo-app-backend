package com.nurullahisik.todo_app.request;

import lombok.Data;

@Data
public class UserLoginRequest {

    String username;

    String password;
}
