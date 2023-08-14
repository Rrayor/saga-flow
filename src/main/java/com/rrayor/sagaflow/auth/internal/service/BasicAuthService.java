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

@Service
@Transactional
@RequiredArgsConstructor
public class BasicAuthService implements AuthService {

    private final AuthUserRepository repository;
    private final BasicJwtService basicJwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthUserMapper authUserMapper;

    public LoginResponseDto register(final RegisterRequestDto dto) {
        final AuthUserEntity savedUser = repository.save(authUserMapper.toEntity(dto));
        final String jwtToken = basicJwtService.generateToken(savedUser);
        return new LoginResponseDto(jwtToken);
    }

    @Override
    public LoginResponseDto login(final LoginRequestDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.username(),
                        dto.password()
                )
        );
        final AuthUserEntity user = repository.findByUsername(dto.username())
                .orElseThrow();
        final String jwtToken = basicJwtService.generateToken(user);
        return new LoginResponseDto(jwtToken);
    }
}
