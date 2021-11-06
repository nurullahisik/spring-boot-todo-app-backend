package com.nurullahisik.todo_app.controller;

import com.nurullahisik.todo_app.entity.Todo;
import com.nurullahisik.todo_app.request.TodoCreateRequest;
import com.nurullahisik.todo_app.request.TodoUpdateRequest;
import com.nurullahisik.todo_app.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<List<Todo>> getUserTodoList(@PathVariable Optional<Long> userId) {
        List<Todo> todos = todoService.getUserTodoList(userId);
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/create")
    public ResponseEntity<Todo> create(TodoCreateRequest newTodo) {
        return ResponseEntity.ok(todoService.create(newTodo));
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> update(@PathVariable Long todoId, TodoUpdateRequest request) {
        return ResponseEntity.ok(todoService.update(todoId, request));
    }

    @DeleteMapping("/{todoId}")
    public void delete(@PathVariable Long todoId){
        todoService.delete(todoId);
    }

}
