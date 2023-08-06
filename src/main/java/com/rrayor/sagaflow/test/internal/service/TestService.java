package com.rrayor.sagaflow.test.internal.service;

import com.rrayor.sagaflow.test.internal.dto.CreateTestDto;
import com.rrayor.sagaflow.test.internal.dto.GetTestDto;

public interface TestService {
    void createTest(final CreateTestDto dto);
    GetTestDto getTest(final Long id);
}
