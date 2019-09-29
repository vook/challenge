package com.challenge.services;

import com.challenge.models.Cliente;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    private Jws<Claims> claims;

    public String generate(Cliente cliente)
    {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(this.expiration));

        return Jwts.builder()
                .setIssuer("")
                .setSubject(cliente.getId().toString())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();
    }

    public boolean isValid(String token)
    {
        try {
            this.claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer getId()
    {
        Claims claims = this.claims.getBody();
        return Integer.parseInt(claims.getSubject());
    }
}
