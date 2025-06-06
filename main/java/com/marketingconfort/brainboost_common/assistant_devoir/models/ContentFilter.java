package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "content_filter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentFilter extends BaseEntity {

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
}
