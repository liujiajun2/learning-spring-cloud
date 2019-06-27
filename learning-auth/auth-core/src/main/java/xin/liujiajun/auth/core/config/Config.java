package xin.liujiajun.auth.core.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xin.liujiajun.auth.core.interceptor.RestTemplateUserContextInterceptor;
import xin.liujiajun.auth.core.interceptor.UserContextInterceptor;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 20:23
 */
@Configuration
@EnableWebMvc
public class Config implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserContextInterceptor());
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateUserContextInterceptor());
        return restTemplate;
    }
}
