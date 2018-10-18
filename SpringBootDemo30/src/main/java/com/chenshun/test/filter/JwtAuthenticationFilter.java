package com.chenshun.test.filter;

import com.chenshun.test.util.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/9/25 23:15  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final PathMatcher pathMatcher = new AntPathMatcher();

    private String protectUrlPattern = "/api/**";

    public JwtAuthenticationFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException,
            IOException {
        try {
            if (isProtectedUrl(request)) {
                Map<String, Object> claims = JwtUtil.validateTokenAndGetClaims(request);
                String role = String.valueOf(claims.get(JwtUtil.ROLE));
                // 最关键的部分就是这里, 我们直接注入了
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(null, null,
                        Collections.singletonList(() -> role)));

                // 检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
                request = JwtUtil.validateTokenAndAddUserIdToHeader(request);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        // 如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
        filterChain.doFilter(request, response);
    }

    private boolean isProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match(protectUrlPattern, request.getServletPath());
    }

}
