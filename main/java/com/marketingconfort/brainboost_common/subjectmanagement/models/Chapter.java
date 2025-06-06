package com.marketingconfort.brainboost_common.subjectmanagement.models;

import com.marketingconfort.brainboost_common.subjectmanagement.enums.*;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chapter extends BaseEntity{
    @Column(unique = true)
    private String name;
    private String description;
    @Column(name = "`order`")
    private Integer order;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;


}

