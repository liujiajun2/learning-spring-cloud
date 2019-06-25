package xin.liujiajun.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 12:29
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "xin.liujiajun.feign")
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
