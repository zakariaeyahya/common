package com.marketingconfort.brainboost_common.assistantmanagement.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssistantManager extends BaseEntity{
    @Column(unique = true)
    private String name;
    private String type;
    private boolean enabled;

    @Column(name = "level_id")
    private Long levelId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "chapter_id")
    private Long chapterId;

    @Column(name = "exercice_id")
    private Long exerciceId;


}
