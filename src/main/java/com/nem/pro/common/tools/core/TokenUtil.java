package com.nem.pro.common.tools.core;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.nem.pro.common.constant.TokenConstant;
import com.nem.pro.common.web.auth.token.TokenValidationException;


import java.util.Date;

public class TokenUtil {

    /**
     * 创建 Token
     * */
    public static String create(String userId,String username){
        return  Jwts.builder()
                .setId(userId)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setIssuer(TokenConstant.ISSUER)
                .signWith(SignatureAlgorithm.HS512, TokenConstant.SECRET)
                .compact();
    }

    /**
     * 解析 Token
     * */
    public static void parse(String token) {
        try {
            Jwts.parser().setSigningKey(TokenConstant.SECRET).parseClaimsJws(token).getBody();
        }catch (Exception e){
            throw new TokenValidationException("token validation failure");
        }
    }

}
