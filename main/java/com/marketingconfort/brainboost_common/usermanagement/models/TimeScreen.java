package com.marketingconfort.brainboost_common.usermanagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;

@Entity
@Table(name = "time_screen", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"child_id", "createdAt"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeScreen extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;
    @Column(nullable = false)
    private Duration duration;
}

