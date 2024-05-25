package com.example.exam9.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProviderDto {

    private Long id;
    private String name;
    private String account;
}
