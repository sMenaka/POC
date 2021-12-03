package com.poc.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(name = "name")
    private String name;

    @Column(name = "activity_code")
    private String activityCode;

    @Column(name = "objectives")
    private String objectives;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "lastUpdate")
    private LocalDateTime lastUpdate;

    @Column(name = "year")
    private String year;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<ProjectUsers> projectUsers;


    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "last_updated_user")
    private String lastUpdateUser;

    @Column(name = "fixed")
    private boolean fixed;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @OneToOne
    @JoinColumn(name = "user",referencedColumnName = "id")
    private User user;

}
