package com.rrayor.sagaflow.auth.internal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(
        @Size(max = 32) @NotNull @NotBlank(message = "Username must not be empty!") String username,
        @NotNull @NotBlank(message = "Password must not be empty!") String password) {

}
