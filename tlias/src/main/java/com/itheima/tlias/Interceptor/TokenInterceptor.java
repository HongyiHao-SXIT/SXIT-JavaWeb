package com.itheima.tlias.Interceptor;

import com.aliyuncs.utils.StringUtils;
import com.itheima.tlias.utils.JwtUtils;
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
        String url = request.getRequestURI();

        if (url.contains("login")) {
            return true;
        }
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }
        try{
            Claims claims = JwtUtils.parseToken(token);
        }catch(Exception e){
response.setStatus(HttpStatus.SC_UNAUTHORIZED);
return false;
        }
return true;

    }

}
