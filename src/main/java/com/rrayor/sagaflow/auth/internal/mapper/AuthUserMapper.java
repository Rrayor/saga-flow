package com.rrayor.sagaflow.auth.internal.mapper;

import com.rrayor.sagaflow.auth.internal.dto.RegisterRequestDto;
import com.rrayor.sagaflow.auth.internal.entity.AuthUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthUserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "authorities", ignore = true)
    AuthUserEntity toEntity(final RegisterRequestDto dto);
}
