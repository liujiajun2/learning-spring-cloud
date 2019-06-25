package xin.liujiajun.ribbon.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 15:36
 */
@RestController
public class TestController {

    @GetMapping("/add")
    public String add(Integer a, Integer b, HttpServletRequest request) {
        return "From Port:" + request.getServerPort() + ", Result: " + (a + b);
    }
}
