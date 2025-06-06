package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "educational_content")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationalContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_modification_date", nullable = false)
    private LocalDateTime lastModificationDate;

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "last_modifier_id", nullable = false)
    private Long lastModifierId;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        lastModificationDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModificationDate = LocalDateTime.now();
    }
}