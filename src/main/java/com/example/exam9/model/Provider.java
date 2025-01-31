package com.example.exam9.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "providers")
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

    @Id
    private Integer account;
    private String name;
    private Double balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider", cascade = CascadeType.ALL)
    private List<ProviderUsers> providerUsers;
}
