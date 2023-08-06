package com.rrayor.sagaflow.test.internal.mapper;

import com.rrayor.sagaflow.test.internal.dto.CreateTestDto;
import com.rrayor.sagaflow.test.internal.dto.GetTestDto;
import com.rrayor.sagaflow.test.internal.entity.TestEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TestMapper {
    TestEntity toTestEntity(CreateTestDto dto);
    GetTestDto toDto(TestEntity entity);
}
