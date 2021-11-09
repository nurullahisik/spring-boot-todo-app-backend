package com.nurullahisik.todo_app.service;

import com.nurullahisik.todo_app.entity.Todo;
import com.nurullahisik.todo_app.entity.User;
import com.nurullahisik.todo_app.repository.TodoRepository;
import com.nurullahisik.todo_app.request.TodoCreateRequest;
import com.nurullahisik.todo_app.request.TodoUpdateRequest;
import com.nurullahisik.todo_app.response.TodoResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    public final TodoRepository todoRepository;
    public final UserService userService;

    public TodoService(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    public List<TodoResponse> getUserTodoList(Optional<Long> userId) {
        if (userId.isPresent()) {
            List<Todo> todos = todoRepository.findByUserId(userId.get());
            return todos.stream().map(TodoResponse::new).collect(Collectors.toList());
        }

        return null;
    }

    public TodoResponse create(TodoCreateRequest newTodo) {
        User user = userService.getUser(newTodo.getUserId());
        if (user == null) {
            return null;
        }

        Todo todo = new Todo();
        todo.setUser(user);
        todo.setDescription(newTodo.getDescription());
        todo.setStatus(false);
        todo.setCreatedAt(LocalDateTime.now());
        todoRepository.save(todo);

        TodoResponse todoResponse = new TodoResponse(todo);
        return todoResponse;
    }

    public TodoResponse update(Long todoId, TodoUpdateRequest request) {

        Optional<Todo> todo = todoRepository.findById(todoId);

        if (todo.isPresent()) {
            Todo foundTodo = todo.get();
            foundTodo.setDescription(request.getDescription());
            todoRepository.save(foundTodo);

            TodoResponse todoResponse = new TodoResponse(foundTodo);

            return todoResponse;
        }
        return null;
    }

    public void delete(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
