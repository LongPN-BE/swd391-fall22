package com.groupswd391.fall22.jwtToken;


import com.groupswd391.fall22.User.User;
import io.jsonwebtoken.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtUtil {
    private static  final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);
    private static final
    long EXPIRE_DURATION = 24 * 60 * 60 * 1000;
     @Value("${app.jwt.security}")
    private String security;
    public String generateAccessToken(User account){
        return Jwts.builder()
                .setSubject(account.getId()+", "+account.getEmail())
                .setIssuer("clonecodeworld")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS256,security)
                .compact();
    }
    public boolean ValidAccessToken(String token){
        try {
            Jwts.parser().setSigningKey(security).parseClaimsJws(token);
            return  true;
        }catch (ExpiredJwtException exception)
        {
        LOGGER.error("JWT expired",exception);
        }catch (IllegalArgumentException exception){
            LOGGER.error("Token is null ,empty or has only whitespace",exception);
        }catch (MalformedJwtException exception){
            LOGGER.error("JWT is invalid",exception);
        }catch (UnsupportedJwtException exception){
            LOGGER.error("JWT is not supported",exception);
        }catch (SignatureException exception){
            LOGGER.error("Signature validation failed", exception);
        }
return false;
    }
    public Claims parseClaims(String token){
        return Jwts.parser().setSigningKey(security).parseClaimsJws(token).getBody();
    }
    public String getSubject(String token){
        return parseClaims(token).getSubject();
    }
}
