package com.skybooker.SkyBooker.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtUtils {

    @Value("${jwtSecretString}")
    private String jwtSecretString;

    private static final long EXPIRATION_TIME = 30L * 24 * 60 * 1000; //30 days in ms
    private SecretKey secretKey;

    @PostConstruct
    private void init() {
        byte[] keybyte = jwtSecretString.getBytes(StandardCharsets.UTF_8);
        this.secretKey = new SecretKeySpec(keybyte, "HmacSHA256");
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email).
                issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }

    public String getUserNameFromToken(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        return claimsTFunction
                .apply(Jwts.
                        parser().
                        verifyWith(secretKey).
                        build()
                        .parseSignedClaims(token)
                        .getPayload());
    }

    public boolean isTokenValid(String token , UserDetails userDetails){
        final String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokeExpired(token));
    }

    private boolean isTokeExpired(String token){
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }
}
