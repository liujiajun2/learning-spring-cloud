package xin.liujiajun.auth.core.util;

import org.springframework.util.StringUtils;
import xin.liujiajun.auth.core.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 20:14
 */
public class UserPermissionUtil {

    /**
     * 模拟权限校验, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
     *
     * @param user
     */
    public static boolean verify(User user, HttpServletRequest request) {
        String url = request.getHeader("x-user-serviceName");
        if (StringUtils.isEmpty(user)) {
            return false;
        } else {
            List<String> str = user.getAllowPermissionService();
            for (String permissionService : str) {
                if (url.equalsIgnoreCase(permissionService)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 模拟权限赋值, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
     *
     * @param user
     */
    public static void permission(User user) {
        if (user.getUsername().equals("admin")) {
            List allowPermissionService = new ArrayList();
            allowPermissionService.add("consumer-service");
            allowPermissionService.add("provider-service");
            user.setAllowPermissionService(allowPermissionService);
        } else if (user.getUsername().equals("spring")) {
            List allowPermissionService = new ArrayList();
            allowPermissionService.add("consumer-service");
            user.setAllowPermissionService(allowPermissionService);
        } else {
            List allowPermissionService = new ArrayList();
            user.setAllowPermissionService(allowPermissionService);
        }
    }
}
