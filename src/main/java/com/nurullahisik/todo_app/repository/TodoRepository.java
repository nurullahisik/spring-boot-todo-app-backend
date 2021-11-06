package com.nurullahisik.todo_app.repository;

import com.nurullahisik.todo_app.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUserId(Long userId);
}
