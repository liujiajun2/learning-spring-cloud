package xin.liujiajun.auth.core.interceptor;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import xin.liujiajun.auth.core.model.User;
import xin.liujiajun.auth.core.util.UserPermissionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 20:07
 */
public class UserContextInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(UserContextInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = getUser(request);
        UserPermissionUtil.permission(user);
        if (!UserPermissionUtil.verify(user,request)){
            response.setHeader("Content-Type","application/json");
            String jsonStr = JSON.toJSONString("no permission access service,please check");
            response.getWriter().write(jsonStr);
            response.getWriter().flush();
            response.getWriter().close();
            throw new PermissionException("no permission access service,please check ");
        }
        UserContextHolder.set(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       UserContextHolder.shutdown();
    }

    private User getUser(HttpServletRequest request){
        String userId = request.getHeader("x-user-id");
        String username = request.getHeader("x-user-name");
        User user = new User();
        user.setUserId(userId);
        user.setUsername(username);
        return user;
    }
    static class PermissionException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public PermissionException(String msg) {
            super(msg);
        }
    }
}
