package com.marketingconfort.brainboost_common.usermanagement.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
public class Parent extends User{
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Child> children;
    @Column(name = "gatewayCustomer_id", nullable = true)
    private String gatewayCustomerId;
}

