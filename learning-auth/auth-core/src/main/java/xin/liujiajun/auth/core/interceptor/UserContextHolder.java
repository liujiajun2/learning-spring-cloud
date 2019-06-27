package xin.liujiajun.auth.core.interceptor;

import xin.liujiajun.auth.core.model.User;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 20:18
 */
public class UserContextHolder {

    public static ThreadLocal<User> context = new ThreadLocal<User>();

    public static User currentUser() {
        return context.get();
    }

    public static void set(User user) {
        context.set(user);
    }

    public static void shutdown() {
        context.remove();
    }
}
