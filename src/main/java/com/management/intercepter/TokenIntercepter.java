package com.management.intercepter;

import com.management.context.CurrentHolder;
import com.management.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class TokenIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        if (path.contains("/login") || path.contains("/register") || path.contains("/css")) return true;
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("用户未登录");
            response.setStatus(401);
            return false;
        }
        try {
            Claims claims = JwtUtils.parseJwt(token);
            Integer id = (Integer) claims.get("id");
            CurrentHolder.setCurrent(id);
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
