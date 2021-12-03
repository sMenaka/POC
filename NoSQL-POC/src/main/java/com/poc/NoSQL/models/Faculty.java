package com.poc.NoSQL.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Document(collation = "faculty")
public class Faculty implements Serializable {

    @Id
    private UUID id ;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
    private boolean deleted;
    @DBRef
    private List<Department> departments;


}
