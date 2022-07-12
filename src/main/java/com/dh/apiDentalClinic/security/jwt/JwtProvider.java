package com.dh.apiDentalClinic.security.jwt;

import com.dh.apiDentalClinic.security.entity.PrincipalUser;
import io.jsonwebtoken.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = Logger.getLogger(JwtProvider.class);

    //@Value("$(jwt.secret)")
    private String secret = "secret";
    //@Value("$(jwt.expiration)")
    private int expiration = 36000;



    public String generateToken(Authentication authentication) {
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(principalUser.getNameUser())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000L))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();

    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Malformed token");
        } catch (UnsupportedJwtException e) {
            logger.error("Token not supported");
        } catch (ExpiredJwtException e) {
            logger.error("Token expiration");
        } catch (IllegalArgumentException e) {
            logger.error("Empty token");
        } catch (SignatureException e) {
            logger.error("Signature fail");
        }
        return false;
    }
}