package com.example.exam9.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private String username;
    @Id
    @Column(name = "personal_account_number")
    private Integer personalAccountNumber;
    @Column(name = "amount_money")
    private Double amountMoney;
    private String password;
    private Boolean enabled;

    private String resetPasswordToken;


    private String selectedLanguage;

    @Column(name = "account_type")
    private Long accountTypeId;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users", cascade = CascadeType.ALL)
    private List<Authority> authorities;

}
