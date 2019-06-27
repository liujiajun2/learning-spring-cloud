package xin.liujiajun.auth.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 20:32
 */
@RestController
public class IndexController {

    @GetMapping("provider/test")
    public String test(HttpServletRequest request){
        System.out.println("----------------success access provider service-------------");
        return "success access provider service!!!";
    }
}
