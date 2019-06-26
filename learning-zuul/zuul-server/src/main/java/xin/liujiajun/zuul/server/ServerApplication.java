package xin.liujiajun.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import xin.liujiajun.zuul.server.filter.FirstPreFilter;
import xin.liujiajun.zuul.server.filter.PostFilter;
import xin.liujiajun.zuul.server.filter.SecondPreFilter;
import xin.liujiajun.zuul.server.filter.ThirdPreFilter;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 15:19
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public FirstPreFilter firstPreFilter() {
        return new FirstPreFilter();
    }

    @Bean
    public SecondPreFilter secondPreFilter(){
        return new SecondPreFilter();
    }
    @Bean
    public ThirdPreFilter thirdPreFilter(){
        return new ThirdPreFilter();
    }

    @Bean
    public PostFilter postFilter(){
        return new PostFilter();
    }

}
