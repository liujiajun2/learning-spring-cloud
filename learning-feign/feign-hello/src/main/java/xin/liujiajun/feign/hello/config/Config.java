package xin.liujiajun.feign.hello.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiuJiaJun
 * @date 2019/6/24 23:47
 */
@Configuration
public class Config {
    /**
     * Logger.Level具体级别如下：
     * NONE:不记录任何信息
     * BASIC:仅记录请求方法，URL，响应状态码和执行时间
     * HEADERS:除了记录BASIC级别的信息外，还会记录请求和响应的头信息
     * FULL:记录所有请求和响应的明细，包括细细，请求体，元数据
     */
    @Bean
    Logger.Level feignLoggerLevel() {

        return Logger.Level.FULL;
    }
}
