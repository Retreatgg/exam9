package com.example.exam9.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
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
