package com.rrayor.sagaflow.auth.internal.mapper;

import com.rrayor.sagaflow.auth.internal.dto.RegisterRequestDto;
import com.rrayor.sagaflow.auth.internal.entity.AuthUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.OffsetDateTime;

@Mapper(imports = OffsetDateTime.class)
public interface AuthUserMapper {

    @Mapping(target = "createdAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "createdBy", constant = "-1L")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "authorities", ignore = true)
    AuthUserEntity toEntity(final RegisterRequestDto dto);
}
