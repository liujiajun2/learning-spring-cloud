package xin.liujiajun.feign.consumer.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.liujiajun.feign.provider.client.model.User;
import xin.liujiajun.feign.provider.client.service.UserService;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 12:35
 */
@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser( @RequestBody @ApiParam(name="用户",value="传入json格式",required=true) User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser( @RequestBody @ApiParam(name="用户",value="传入json格式",required=true) User user){
        return userService.updateUser(user);
    }
}
