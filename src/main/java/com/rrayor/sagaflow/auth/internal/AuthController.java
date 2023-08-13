package com.rrayor.sagaflow.auth.internal;

import com.rrayor.sagaflow.auth.internal.dto.LoginRequestDto;
import com.rrayor.sagaflow.auth.internal.dto.LoginResponseDto;
import com.rrayor.sagaflow.auth.internal.dto.RegisterRequestDto;
import com.rrayor.sagaflow.auth.internal.service.BasicAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("auth")
@RequiredArgsConstructor
public class AuthController {

    private final BasicAuthService authService;

    @PostMapping("")
    public LoginResponseDto register(@RequestBody @Valid RegisterRequestDto dto) {
        return authService.register(dto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody @Valid LoginRequestDto dto) {
        return authService.login(dto);
    }
}
