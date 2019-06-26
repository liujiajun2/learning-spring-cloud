package xin.liujiajun.zuul.server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LiuJiaJun
 * @date 2019/6/26 15:53
 */
public class ThirdPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        //从上下文获取Logic-is-success，用于判断此Filter是否执行
        return (boolean)context.get("logic-is-success");
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("这是ThirdPreFilter");
        //从RequestContext获取上下文
        RequestContext context = RequestContext.getCurrentContext();
        //从上下文获取HttpServletRequest
        HttpServletRequest request = context.getRequest();
        //获取a参数
        String b = request.getParameter("b");
        if (null == b){
            //对该请求禁止路由，也就是禁止访问下游服务
            context.setSendZuulResponse(false);
            //设定responseBody供PostFilter使用
            context.setResponseBody("{\"status\":500.\"message\":\"b参数为空\"}");
            //logic-is-success保存到上下文，作为同类型下游Filter的执行开关
            context.set("logic-is-success",false);
            return null;
        }
        return null;
    }
}
