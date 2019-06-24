package xin.liujiajun.feign.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiuJiaJun
 * @date 2019/6/24 20:16
 */
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = {})
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
