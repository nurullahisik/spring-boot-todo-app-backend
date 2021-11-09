package com.nurullahisik.todo_app.entity;

import com.nurullahisik.todo_app.response.UserResponse;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100)
    String name;

    @Column(length = 100)
    String surname;

    @Column(length = 100)
    String username;

    String password;
}
