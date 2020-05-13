package io.github.lmikoto.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8000","https://lmikoto.github.io","https://miko-tools.netlify.com","https://t.lmikoto.com")
                        .allowCredentials(true)
                        .allowedMethods("GET","POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .exposedHeaders("Header1", "Header2");
            }
        };
    }
}