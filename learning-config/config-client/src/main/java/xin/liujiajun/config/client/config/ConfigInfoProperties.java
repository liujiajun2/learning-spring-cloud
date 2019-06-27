package xin.liujiajun.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 10:18
 */
@Component
@RefreshScope
public class ConfigInfoProperties {

    @Value("${cn.spring.config}")
    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
