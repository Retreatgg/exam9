package com.example.exam9.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "from_account_id")
    private Integer fromAccountId;
    @JoinColumn(name = "to_account_id")
    private Integer toAccountId;
    private Double amount;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;
}
