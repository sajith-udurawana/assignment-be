package com.sajith.udurawana.CRUDDemo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sajith.udurawana.CRUDDemo.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * Implementation of the JwtService interface for JWT token handling.
 * Manages token extraction, generation, and validation.
 */
@Service
public class JwtServiceImpl implements JwtService {
    @Value("${app.security.secret}")
    private String SECURITY_KEY;

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECURITY_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String extractEmail(String jwToken) {
        return extractClaims(jwToken, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails details) {
        return generateToken(new HashMap<>(), details);
    }

    @Override
    public boolean isValidToken(String token, UserDetails details) {
        final String email = extractEmail(token);
        return email.equals(details.getUsername()) && !isExpiredToken(token);
    }

    private boolean isExpiredToken(String token) {
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }

    public String generateToken(Map<String, Object> claims, UserDetails details) {
        return Jwts.builder().setClaims(claims).setSubject(details.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}
