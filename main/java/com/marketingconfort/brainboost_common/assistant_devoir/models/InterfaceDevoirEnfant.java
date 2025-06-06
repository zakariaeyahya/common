package com.marketingconfort.brainboost_common.assistant_devoir.models;

import com.marketingconfort.brainboost_common.assistantmanagement.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "interface_devoir_enfant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceDevoirEnfant extends BaseEntity {

    @Column(name = "assistant_id", nullable = false)
    private Long assistantId;

    @Column(name = "welcome_message", columnDefinition = "TEXT")
    private String welcomeMessage;

    @Column(name = "daily_tip", columnDefinition = "TEXT")
    private String dailyTip;
}