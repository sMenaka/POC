package com.poc.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "lastUpdate")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ProjectUsers> projectUsers;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @Column(name = "deleted")
    private boolean deleted;

}