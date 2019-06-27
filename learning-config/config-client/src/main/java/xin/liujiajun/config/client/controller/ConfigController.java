package xin.liujiajun.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.liujiajun.config.client.config.ConfigInfoProperties;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 10:20
 */
@RestController
public class ConfigController {
    @Autowired
    private ConfigInfoProperties configInfoProperties;

    @GetMapping("getConfig")
    public String getConfigInfo() {
        return configInfoProperties.getConfig();
    }
}
