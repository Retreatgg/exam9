package com.example.exam9.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    @NotEmpty
    private String username;

    @NotBlank
//    @Size(min = 4, max = 24, message = "${user.validation.password.size}")
//    @Pattern(
//            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
//            message = "${user.validation.password.pattern}"
//    )
    private String password;

}
