package com.rrayor.sagaflow.auth.internal.service;

import com.rrayor.sagaflow.auth.internal.dto.LoginRequestDto;
import com.rrayor.sagaflow.auth.internal.dto.RegisterRequestDto;
import com.rrayor.sagaflow.auth.internal.dto.LoginResponseDto;
import com.rrayor.sagaflow.auth.internal.entity.AuthUserEntity;
import com.rrayor.sagaflow.auth.internal.mapper.AuthUserMapper;
import com.rrayor.sagaflow.auth.internal.repository.AuthUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class BasicAuthService implements AuthService {

    private final AuthUserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthUserMapper authUserMapper;

    public LoginResponseDto register(final RegisterRequestDto dto) {
        AuthUserEntity savedUser = repository.save(authUserMapper.toEntity(dto));
        String jwtToken = jwtService.generateToken(savedUser);
        String refreshToken = jwtService.generateRefreshToken(savedUser);
        return new LoginResponseDto(jwtToken, refreshToken);
    }

    @Override
    public LoginResponseDto login(final LoginRequestDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );
        AuthUserEntity user = repository.findByUsername(dto.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        return new LoginResponseDto(jwtToken, refreshToken);
    }
}
