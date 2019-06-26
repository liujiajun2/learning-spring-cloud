package xin.liujiajun.hystrix.service;

import com.netflix.hystrix.HystrixObservableCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;

/**
 * @author LiuJiaJun
 * @date 2019/6/25 23:02
 */
@Service
public class UserService {

    @HystrixCommand(fallbackMethod = "defaultUser")
    public String getUser(String username) throws Exception {
        if (username.equals("spring")) {
            return "this is real user";
        } else {
            throw new Exception();
        }
    }

    public String defaultUser(String username) {
        return "the user does not exist in this system";
    }

}
