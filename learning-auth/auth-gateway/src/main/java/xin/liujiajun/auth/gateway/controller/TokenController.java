package xin.liujiajun.auth.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xin.liujiajun.auth.gateway.util.JwtUtil;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 19:50
 */
@RestController
public class TokenController {

    @GetMapping("/getToken/{name}")
    public String get(@PathVariable("name") String name) {
        return JwtUtil.generateToken(name);
    }
}
