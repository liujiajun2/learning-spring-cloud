package xin.liujiajun.ribbon.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 15:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
