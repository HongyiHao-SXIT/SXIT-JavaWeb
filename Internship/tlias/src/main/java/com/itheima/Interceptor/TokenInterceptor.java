package com.itheima.Interceptor;

import com.aliyuncs.utils.StringUtils;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            response.setStatus(401);
            return false;
        }
        try {
            Claims claims = JwtUtils.parseJWT(token);
        } catch (Exception e) {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
