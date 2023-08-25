package com.avigail.coupons.utils;

import com.avigail.coupons.dto.UserData;
import com.avigail.coupons.utils.consts.Consts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JWTUtils {
    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(Consts.JWT_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
    public static String createJWT(UserData userData) throws JsonProcessingException {
        //יודע לקחת אובייקט ג'וואי ולהמיר לג'יקסון או לחילופין לקחת סטרינג שהוא ג'יסון לספק לו את הגלופה של איך הקלאס אמור להראות ועל סמך זה
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonLoginDetails = objectMapper.writeValueAsString(userData);
        return createJWT("0", "Avi", jsonLoginDetails, 0);
    }

    public static String createJWT(String subject) {
        return createJWT("0", "Avi", subject, 0);
    }

    private static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Consts.JWT_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static void validateToken(String token) throws Exception {
        Claims claims = decodeJWT(token);
    }
}

