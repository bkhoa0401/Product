package com.ecommerce.wProductService.security;


import io.jsonwebtoken.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ecommerce.wProductService.security.bean.CustomUserDetails;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${secret.key:default}")
    private String JWT_SECRET;
    
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    //@Value("${time.expire:100000L)}")
    private long JWT_EXPIRATION = 2400000L;

    public String generateToken(CustomUserDetails userDetails) {
        Date now = new Date();
        Date expire = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUserNameByToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
        	logger.error("Invalid JWT Token");
        } catch (ExpiredJwtException ex) {
        	logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
        	logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
        	logger.error("JWT claims string is empty.");
        }
        return false;
    }

}
