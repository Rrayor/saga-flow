package com.rrayor.sagaflowbackend.test.internal.mapper;

import com.rrayor.sagaflowbackend.test.internal.dto.CreateTestDto;
import com.rrayor.sagaflowbackend.test.internal.dto.GetTestDto;
import com.rrayor.sagaflowbackend.test.internal.entity.TestEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TestMapper {
    TestEntity toTestEntity(CreateTestDto dto);
    GetTestDto toDto(TestEntity entity);
}
