package com.chenshun.test.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 * User: chenshun131 <p />
 * Time: 18/9/25 23:08  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
public class JwtUtil {

    /** 1000 hour */
    public static final long EXPIRATION_TIME = 3600_000_000L;

    /** 加密的秘钥 */
    public static final String SECRET = "ThisIsASecret";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    /** 存储在 Header 中的信息 */
    public static final String USER_NAME = "username";

    public static final String ROLE = "ROLE";

    /**
     * 生成一个有效期 1000小时 的jwt
     *
     * @param userId
     * @return
     */
    public static String generateToken(String userId) {
        HashMap<String, Object> map = new HashMap<>(1);
        //you can put any data in the map
        map.put(USER_NAME, userId);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        // jwt 前面一般都会加 Bearer
        return TOKEN_PREFIX + jwt;
    }

    public static Map<String, Object> validateTokenAndGetClaims(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token == null) {
            throw new TokenValidationException("Missing token");
        }
        // parse the token. exception when token is invalid
        Map<String, Object> body = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody();
        return body;
    }

    /**
     * 校验jwt并 Payload 中的数据放入 Header 中
     *
     * @param request
     * @return
     */
    public static HttpServletRequest validateTokenAndAddUserIdToHeader(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            try {
                Map<String, Object> body = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();
                // 通过CustomHttpServletRequest实现了修改Request
                return new CustomHttpServletRequest(request, body);
            } catch (Exception e) {
                log.info(e.getMessage());
                throw new TokenValidationException(e.getMessage());
            }
        } else {
            throw new TokenValidationException("Missing token");
        }
    }

    public static class CustomHttpServletRequest extends HttpServletRequestWrapper {

        private Map<String, String> claims;

        public CustomHttpServletRequest(HttpServletRequest request, Map<String, ?> claims) {
            super(request);
            this.claims = new HashMap<>();
            // 把jwt里面的信息都保存下来
            claims.forEach((k, v) -> this.claims.put(k, String.valueOf(v)));
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            if (claims != null && claims.containsKey(name)) {
                // 如果jwt都这个数据, 就直接返回
                return Collections.enumeration(Arrays.asList(claims.get(name)));
            }
            return super.getHeaders(name);
        }

        public Map<String, String> getClaims() {
            return claims;
        }
    }

    static class TokenValidationException extends RuntimeException {

        public TokenValidationException(String msg) {
            super(msg);
        }

    }

}