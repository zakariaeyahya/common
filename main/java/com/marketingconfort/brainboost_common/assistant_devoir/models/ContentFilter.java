package com.marketingconfort.brainboost_common.assistant_devoir.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "content_filter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assistant_id", nullable = false)
    private Long assistantId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "filter_type", length = 50, nullable = false)
    private String filterType;

    @ElementCollection
    @CollectionTable(
            name = "content_filter_blocked_terms",
            joinColumns = @JoinColumn(name = "filter_id")
    )
    @Column(name = "blocked_term")
    private List<String> blockedTerms;

    @ElementCollection
    @CollectionTable(
            name = "content_filter_user_types",
            joinColumns = @JoinColumn(name = "filter_id")
    )
    @Column(name = "user_type")
    private List<String> userTypes;

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