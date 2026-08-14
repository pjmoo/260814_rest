package org.example.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/board/**")
                // @Value나 property로 불러오기 할 수도 있음
                .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
                .allowedHeaders("Content-Type")
                .maxAge(3600) // 매번 허용받으면 서버에 부하가 가겠죠??
        // 캐싱해서 1시간 (60초 * 60분) -> 동일한 cors로 적용
        ;
    }
}
