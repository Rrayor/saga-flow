package com.rrayor.sagaflowbackend.test.internal.service;

import com.rrayor.sagaflowbackend.test.CreateTestDto;
import com.rrayor.sagaflowbackend.test.GetTestDto;

public interface TestService {
    void createTest(final CreateTestDto dto);
    GetTestDto getTest(final Long id);
}
