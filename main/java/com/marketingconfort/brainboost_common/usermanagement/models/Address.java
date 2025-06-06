package com.marketingconfort.brainboost_common.usermanagement.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity{
    private String country;
    private String complimentaryAddress;
    private String city;
    private String fullAddress;
    private String zipCode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
