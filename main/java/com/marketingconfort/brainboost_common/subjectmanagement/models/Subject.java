package com.marketingconfort.brainboost_common.subjectmanagement.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends BaseEntity{
    @Column(unique = true)
    private String name;
    private String description;
    private boolean active;
    private String color;


    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Chapter> chapters;



}

