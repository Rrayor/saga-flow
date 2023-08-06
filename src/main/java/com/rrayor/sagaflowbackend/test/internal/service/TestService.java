package com.rrayor.sagaflowbackend.test.internal.service;

import com.rrayor.sagaflowbackend.test.internal.dto.CreateTestDto;
import com.rrayor.sagaflowbackend.test.internal.dto.GetTestDto;

public interface TestService {
    void createTest(final CreateTestDto dto);
    GetTestDto getTest(final Long id);
}
