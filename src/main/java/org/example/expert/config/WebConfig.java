package org.example.expert.config;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.annotation.Auth;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    //HttpServletRequest -> AuthUser -> @Auth AuthUser authUser로 전달하는 객체 생성

    private final AuthUserArgumentResolver authUserArgumentResolver;

    /*
     * 4. 스프링이 컨트롤러의 파라미터를 처리할 때 사용할 '정보 리스트'에 커스텀 Resolver를 추가하는 작업
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authUserArgumentResolver);
    }
}
