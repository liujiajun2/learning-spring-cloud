package xin.liujiajun.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.liujiajun.hystrix.service.UserService;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 23:09
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public String getUser(@RequestParam(value = "username") String username) throws Exception {
        return userService.getUser(username);
    }
}
