package com.example.exam9.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "provider_users")
@NoArgsConstructor
@AllArgsConstructor
public class ProviderUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Column(name = "account_number")
    private Integer accountNumber;

    private Double balance;
}
