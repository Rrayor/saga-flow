package com.rrayor.sagaflow.auth.internal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    @Size(max = 32)
    @NotNull
    @NotBlank(message = "Username must not be empty!")
    private String username;

    @NotNull
    @NotBlank(message = "Password must not be empty!")
    private String password;
}
