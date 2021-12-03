package com.poc.NoSQL.models;


import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import java.util.UUID;

@Document(collation = "user")
@Data
public class User {

    @Id
    private UUID id;

    private String username;

    private String password;

    private String email;

    private boolean enabled;

    private LocalDateTime createdAt;

    private LocalDateTime lastUpdate;

    private Department department;

    private boolean deleted;
}
