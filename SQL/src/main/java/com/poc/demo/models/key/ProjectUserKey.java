package com.poc.demo.models.key;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProjectUserKey implements Serializable {
    @Column(name = "project_id")
    private Integer project;
    @Column(name = "user_id")
    private Integer user;
}
