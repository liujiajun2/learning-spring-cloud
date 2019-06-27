package xin.liujiajun.auth.core.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import xin.liujiajun.auth.core.model.User;

import java.io.IOException;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 20:21
 */
public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        User user = UserContextHolder.currentUser();
        request.getHeaders().add("x-user-id", user.getUserId());
        request.getHeaders().add("x-user-name", user.getUsername());
        request.getHeaders().add("x-user-serviceName", request.getURI().getHost());
        return execution.execute(request, bytes);
    }
}
