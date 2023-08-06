package com.rrayor.sagaflow.test.internal.service;

import com.rrayor.sagaflow.test.internal.dto.CreateTestDto;
import com.rrayor.sagaflow.test.internal.dto.GetTestDto;
import com.rrayor.sagaflow.test.internal.entity.TestEntity;
import com.rrayor.sagaflow.test.internal.mapper.TestMapper;
import com.rrayor.sagaflow.test.internal.repository.TestRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasicTestService implements TestService{
    private static final Logger log = LoggerFactory.getLogger(BasicTestService.class);

    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Override
    public void createTest(@NotNull final CreateTestDto dto) {
        testRepository.save(testMapper.toTestEntity(dto));
    }

    @Override
    public GetTestDto getTest(@NotNull final Long id) {
        log.info("Getting Test with id: {}", id);

        final TestEntity entity = testRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Test not found"));

        return testMapper.toDto(entity);
    }
}
