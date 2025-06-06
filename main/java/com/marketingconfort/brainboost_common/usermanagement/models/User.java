package com.marketingconfort.brainboost_common.usermanagement.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.marketingconfort.brainboost_common.usermanagement.enums.UserStatus;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User extends BaseEntity {
    private String lastName;
    private String firstName;
    private String email;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String phoneNumber;
    private String photo ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_address_id")
    private Address primaryAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_address_id")
    private Address secondaryAddress;
    private LocalDateTime lastLogin;
    @Transient
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserStatusHistory> userStatusHistories;
}
