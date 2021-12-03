package com.poc.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "faculty")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Faculty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "name")
    private String name;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "lastUpdate")
    private LocalDateTime lastUpdate;
    @Column(name = "deleted")
    private boolean deleted;
    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;


}
