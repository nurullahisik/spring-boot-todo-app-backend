package com.nurullahisik.todo_app.response;

import com.nurullahisik.todo_app.entity.Todo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoResponse {

    Long id;

    Long userId;

    String description;

    Boolean status;

    LocalDateTime createdAt;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.userId = todo.getUser().getId();
        this.description = todo.getDescription();
        this.status = todo.getStatus();
        this.createdAt = todo.getCreatedAt();
    }
}
