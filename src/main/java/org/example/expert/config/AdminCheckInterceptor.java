package org.example.expert.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.expert.domain.common.exception.InvalidRequestException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.management.Attribute;

public class AdminCheckInterceptor implements HandlerInterceptor {

    @Override

    // 역할 가져오기
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        Object Role = request.getAttribute("userRole");

        // 역할이랑 일치하는지 확인
        if (Role == null || !"Admin".equals(Role.toString())) {
            throw new InvalidRequestException(" 어드민 권한이 필요합니다.");
        }

        // 특이사항 없으면 true
        return true;
    }
}
