package com.nurullahisik.todo_app.request;

import lombok.Data;

@Data
public class TodoCreateRequest {

    String description;

    Long userId;

}
