package xin.liujiajun.consul.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 18:49
 */
@SpringBootApplication
@RestController
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @GetMapping("/actuator/health")
    public String health() {
        return "SUCCESS";
    }

    @GetMapping("sayHello")
    public String sayHello(String name) {
        return "Hello，" + name;
    }
}
