package com.walidoow.concordiaAuthAPI.entity.user;

import com.walidoow.concordiaAuthAPI.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@SuperBuilder(toBuilder = true, setterPrefix = "with")
public class User extends BaseEntity {

    @Column(unique = true)
    private String netname;

    @Column(name = "phone_number")
    private String phoneNumber;

}
