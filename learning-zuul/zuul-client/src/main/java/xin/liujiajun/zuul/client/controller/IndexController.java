package xin.liujiajun.zuul.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 15:24
 */
@RestController
public class IndexController {

    @GetMapping("add")
    public Integer getIndex(Integer a,Integer b) {
        return a + b;
    }
}
