package com.rrayor.sagaflow.test.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTestDto {

    private Long id;
    private String testVarchar;
}
