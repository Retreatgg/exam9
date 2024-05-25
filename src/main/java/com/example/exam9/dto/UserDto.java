package com.example.exam9.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String username;
    private Integer personalAccountNumber;
    private Double amountMoney;
    private String selectedLanguage;
}
