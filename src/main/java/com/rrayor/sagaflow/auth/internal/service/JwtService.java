package com.rrayor.sagaflow.auth.internal.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    String extractUsername(final String token);

    <T> T extractClaim(final String token, final Function<Claims, T> claimsResolver);
    String generateToken(final UserDetails userDetails);

    String generateToken(final Map<String, Object> extraClaims, final UserDetails userDetails);

    boolean isTokenValid(final String token, final UserDetails userDetails);
}
