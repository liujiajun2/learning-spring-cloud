package xin.liujiajun.ribbon.ribbon;

import org.bouncycastle.jcajce.provider.digest.RIPEMD128;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import xin.liujiajun.ribbon.ribbon.config.AvoidScan;
import xin.liujiajun.ribbon.ribbon.config.Config;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 15:39
 */
@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "client-a",configuration = Config.class)
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {AvoidScan.class})})
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
