package xin.liujiajun.hystrix.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 8:40
 */
@RestController
public class TestController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(@RequestParam("username") String username) throws Exception {
        if (username.equals("spring")) {
            return "This is real user";
        } else {
            throw new Exception();
        }
    }
}
