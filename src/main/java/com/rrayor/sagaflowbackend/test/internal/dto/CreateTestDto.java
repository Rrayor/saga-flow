package com.rrayor.sagaflowbackend.test.internal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTestDto {
    @Size(max = 255)
    @NotNull(message = "testVarchar should not be null")
    private String testVarchar;
}
