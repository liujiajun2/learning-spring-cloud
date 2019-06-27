package xin.liujiajun.auth.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 20:39
 */
@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println("----------------success access test method!----------------");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            System.out.println(key + ": " + request.getHeader(key));
        }
        return "success access test method!!";
    }

    @RequestMapping("/accessProvider")
    public String accessProvider(HttpServletRequest request) {
        String result = restTemplate.getForObject("http://provider-service/provider/test", String.class);
        return result;
    }

}
