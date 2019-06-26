package xin.liujiajun.hystrix.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xin.liujiajun.hystrix.consumer.service.impl.UserServiceFallback;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 8:44
 */
@FeignClient(name = "provider",fallback = UserServiceFallback.class)
public interface IUserService {

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(@RequestParam("username") String username);
}
