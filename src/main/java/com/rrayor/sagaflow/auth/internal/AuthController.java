package com.rrayor.sagaflow.auth.internal;

import com.rrayor.sagaflow.auth.internal.dto.LoginRequestDto;
import com.rrayor.sagaflow.auth.internal.dto.LoginResponseDto;
import com.rrayor.sagaflow.auth.internal.dto.RegisterRequestDto;
import com.rrayor.sagaflow.auth.internal.service.BasicAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final BasicAuthService authService;

    @PostMapping("/auth/register")
    public LoginResponseDto register(@RequestBody @Valid final RegisterRequestDto dto) {
        return authService.register(dto);
    }

    @PostMapping("/auth/login")
    public LoginResponseDto login(@RequestBody @Valid final LoginRequestDto dto) {
        return authService.login(dto);
    }
}
