package xin.liujiajun.ribbon.ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 16:10
 */
@Configuration
@AvoidScan
public class Config {

//    @Autowired
//    IClientConfig clientConfig;
//
//    @Bean
//    public IRule ribbonRUle(IClientConfig clientConfig) {
//        return new RandomRule();
//    }
}
