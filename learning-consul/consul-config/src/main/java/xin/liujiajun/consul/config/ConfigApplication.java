package xin.liujiajun.consul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 19:02
 */
@SpringBootApplication
@RestController
@RefreshScope //参数值修改后自动刷新
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

    @Value("${foo.bar.name}")
    private String name;

    @GetMapping("/getName")
    public String getName() {
        return name;
    }
}
