package com.poc.demo.models;

import com.poc.demo.models.key.ProjectUserKey;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "project_users")
@Data
public class ProjectUsers implements Serializable {
    @EmbeddedId
    private ProjectUserKey id;
    @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne( cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;



    @Column(name = "join_at")
    private LocalDateTime joinAt;

    @Column(name = "lastUpdate")
    private LocalDateTime lastUpdate;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "addedBy")
    private String addedBy;
}
