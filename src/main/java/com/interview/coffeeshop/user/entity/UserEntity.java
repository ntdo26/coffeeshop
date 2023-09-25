package com.interview.coffeeshop.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "user_information")
@Table
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String tenant;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userName;
}
