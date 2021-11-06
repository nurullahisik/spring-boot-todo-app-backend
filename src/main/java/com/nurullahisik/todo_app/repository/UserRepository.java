package com.nurullahisik.todo_app.repository;

import com.nurullahisik.todo_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
