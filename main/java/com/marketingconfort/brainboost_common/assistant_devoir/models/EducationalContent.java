package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "educational_content")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationalContent extends BaseEntity {

    @Column(name = "assistant_id", nullable = false)
    private Long assistantId;

    @Column(name = "level_id", nullable = false)
    private Long levelId;

    @Column(name = "subject_id", nullable = false)
    private Long subjectId;

    @Column(name = "chapter_id", nullable = false)
    private Long chapterId;

    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column(name = "content_type", length = 50, nullable = false)
    private String contentType;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}