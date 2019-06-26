package xin.liujiajun.zuul.server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.nio.charset.StandardCharsets;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 15:56
 */
public class PostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("这是PostFilter");
        RequestContext context = RequestContext.getCurrentContext();
        context.getResponse().setCharacterEncoding("UTF-8");
        //获取上下文保存的responseBody
        String responseBody = context.getResponseBody();
        if (null != responseBody) {
            context.setResponseStatusCode(500);
            context.setResponseBody(responseBody);
        }
        return null;
    }
}
