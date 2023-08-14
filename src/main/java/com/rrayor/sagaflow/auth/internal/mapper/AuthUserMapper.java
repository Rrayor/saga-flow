package com.rrayor.sagaflow.auth.internal.mapper;

import com.rrayor.sagaflow.auth.internal.dto.RegisterRequestDto;
import com.rrayor.sagaflow.auth.internal.entity.AuthUserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AuthUserMapper {

    AuthUserEntity toEntity(final RegisterRequestDto dto);
}
