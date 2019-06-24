package xin.liujiajun.feign.hello.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LiuJiaJun
 * @date 2019/6/24 23:16
 */
@FeignClient(name = "github-client", url = "https://api.github.com")
public interface CompressionFeignService {
    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    ResponseEntity<byte []> searchRepo(@RequestParam("q") String queryStr);
}
