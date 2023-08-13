package com.rrayor.sagaflow.auth.internal.mapper;

import com.rrayor.sagaflow.auth.internal.dto.RegisterRequestDto;
import com.rrayor.sagaflow.auth.internal.dto.LoginResponseDto;
import com.rrayor.sagaflow.auth.internal.entity.AuthUserEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

@Mapper
public interface AuthUserMapper {

    AuthUserEntity toEntity(RegisterRequestDto dto);

    @BeanMapping(ignoreUnmappedSourceProperties = "password")
    LoginResponseDto toDto(AuthUserEntity entity);
}
