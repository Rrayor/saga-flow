package com.rrayor.sagaflowbackend.test;

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
