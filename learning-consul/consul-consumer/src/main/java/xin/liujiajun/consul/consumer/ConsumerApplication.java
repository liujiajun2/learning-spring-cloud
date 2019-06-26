package xin.liujiajun.consul.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.liujiajun.consul.consumer.service.HelloService;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 18:53
 */
@SpringBootApplication
@RestController
@EnableFeignClients
public class ConsumerApplication {

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @GetMapping("/actuator/health")
    public String health() {
        return "SUCCESS";
    }

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(name = "name") String name) {
        return helloService.sayHello(name);
    }
}
