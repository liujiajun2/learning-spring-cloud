package xin.liujiajun.feign.provider.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.liujiajun.feign.provider.client.model.User;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 12:06
 */
@FeignClient(name = "provider")
public interface UserService {

    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    String addUser(User user);

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    String updateUser(@RequestBody User user);
}
