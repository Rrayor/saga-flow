package com.rrayor.sagaflow.auth.internal.service;

import com.rrayor.sagaflow.auth.internal.dto.LoginRequestDto;
import com.rrayor.sagaflow.auth.internal.dto.RegisterRequestDto;
import com.rrayor.sagaflow.auth.internal.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto register(final RegisterRequestDto dto);
    LoginResponseDto login(final LoginRequestDto dto);
}
