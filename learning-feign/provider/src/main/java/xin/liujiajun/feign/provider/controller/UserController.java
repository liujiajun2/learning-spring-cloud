package xin.liujiajun.feign.provider.controller;

import org.springframework.web.bind.annotation.RestController;
import xin.liujiajun.feign.provider.client.model.User;
import xin.liujiajun.feign.provider.client.service.UserService;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 12:16
 */
@RestController
public class UserController implements UserService {
    @Override
    public String addUser(User user) {
        return "hello," + user.getName();
    }

    @Override
    public String updateUser(User user) {
        return "update," + user.getName();
    }
}
