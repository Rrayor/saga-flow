package com.rrayor.sagaflow.auth.internal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDto(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {

}
