package com.marketingconfort.brainboost_common.usermanagement.models;
import com.marketingconfort.brainboost_common.usermanagement.enums.PermissionType;
import com.marketingconfort.brainboost_common.usermanagement.enums.SubModule;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Enumerated(EnumType.STRING)
    private SubModule subModule;

    @Enumerated(EnumType.STRING)
    private PermissionType permissionType;

}