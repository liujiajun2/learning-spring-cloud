package xin.liujiajun.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 14:15
 */
@SpringBootApplication
public class GatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDemoApplication.class,args);
    }


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        //方式一
        return builder.routes()
                .route(r->r.path("/jd").uri("https://www.jd.com").id("jd_route"))
                .build();
    }

}
