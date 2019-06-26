package xin.liujiajun.zuul.server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 *  模拟业务需求，使用SecondPreFilter来验证是否传入a参数
 *  使用ThirdPreFilter来验证是否传入b参数，最后在PostFilter统一处理返回内容
 *
 * @author LiuJiaJun
 * @date 2019/6/26 15:46
 */
public class SecondPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("这是SecondPreFilter");
        //从RequestContext获取上下文
        RequestContext context = RequestContext.getCurrentContext();
        //从上下文获取HttpServletRequest
        HttpServletRequest request = context.getRequest();
        //获取a参数
        String a = request.getParameter("a");
        if (null == a){
            //对该请求禁止路由，也就是禁止访问下游服务
            context.setSendZuulResponse(false);
            //设定responseBody供PostFilter使用
            context.setResponseBody("{\"status\":500.\"message\":\"a参数为空\"}");
            //logic-is-success保存到上下文，作为同类型下游Filter的执行开关
            context.set("logic-is-success",false);
            return null;
        }
        context.set("logic-is-success",true);
        return null;
    }
}
