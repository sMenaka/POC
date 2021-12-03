package com.poc.NoSQL.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collation = "project")
public class Project {
    @Id
    private UUID id ;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime lastUpdate;

    private String year;

    private boolean deleted;

    private String lastUpdateUser;
    @DBRef
    private Department department;
    @DBRef
    private User user;

}