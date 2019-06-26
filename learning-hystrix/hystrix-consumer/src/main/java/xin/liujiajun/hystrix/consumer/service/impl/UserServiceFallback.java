package xin.liujiajun.hystrix.consumer.service.impl;

import org.springframework.stereotype.Component;
import xin.liujiajun.hystrix.consumer.service.IUserService;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 8:45
 */
@Component
public class UserServiceFallback implements IUserService {

    @Override
    public String getUser(String username) {
        return "The user does not exist in this system, please confirm username";
    }
}
