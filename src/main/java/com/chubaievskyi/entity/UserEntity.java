package com.chubaievskyi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @JoinColumn(name = "last_name")
    private String lastName;

    @Column(name = "ipn", unique = true, nullable = false)
    private String ipn;
}