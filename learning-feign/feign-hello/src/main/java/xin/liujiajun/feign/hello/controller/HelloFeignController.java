package xin.liujiajun.feign.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.liujiajun.feign.hello.service.CompressionFeignService;
import xin.liujiajun.feign.hello.service.HelloFeignService;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author LiuJiaJun
 * @date 2019/6/24 21:44
 */
@RestController
public class HelloFeignController {
    @Autowired
    private HelloFeignService helloFeignService;
    @Autowired
    private CompressionFeignService compressionFeignService;

    @GetMapping(value = "/search/github")
    public String searchGithubRepoByStr(@RequestParam("str") String queryStr) {
        return helloFeignService.searchRepo(queryStr);
    }

    @GetMapping(value = "/search/github/compression")
    public String searchGithubRepoByStr2(@RequestParam("str") String queryStr) {
        ResponseEntity<byte[]> responseEntity = compressionFeignService.searchRepo(queryStr);
        byte[] body = responseEntity.getBody();
        return new String(body, StandardCharsets.UTF_8);
    }
}
