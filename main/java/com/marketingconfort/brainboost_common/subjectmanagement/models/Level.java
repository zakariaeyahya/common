package com.marketingconfort.brainboost_common.subjectmanagement.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Level extends BaseEntity{
    @Column(unique = true)
    private String name;
    private String code;
    private String description;
    private boolean active;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<Subject> subjects;


}

