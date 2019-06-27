package xin.liujiajun.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 9:36
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
//        http://localhost:8081/config-info/dev/master 访问配置信息
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
