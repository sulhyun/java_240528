package kr.kh.spring_react.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 실제 배포 시에는 특정 주소만 넣는 게 안전해요
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
