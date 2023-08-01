package com.rrayor.sagaflowbackend.test.internal.service;

import com.rrayor.sagaflowbackend.test.CreateTestDto;
import com.rrayor.sagaflowbackend.test.GetTestDto;
import com.rrayor.sagaflowbackend.test.internal.entity.TestEntity;
import com.rrayor.sagaflowbackend.test.internal.mapper.TestMapper;
import com.rrayor.sagaflowbackend.test.internal.repository.TestRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasicTestService implements TestService{
    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Override
    public void createTest(@NotNull final CreateTestDto dto) {
        testRepository.save(testMapper.toTestEntity(dto));
    }

    @Override
    public GetTestDto getTest(@NotNull final Long id) {
        final TestEntity entity = testRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Test not found"));

        return testMapper.toDto(entity);
    }
}
