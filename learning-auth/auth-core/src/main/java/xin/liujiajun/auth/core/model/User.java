package xin.liujiajun.auth.core.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 20:09
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1;
    public final static String CONTEXT_KEY_USER_ID = "x-user-id";

    private String userId;
    private String username;
    private List<String> allowPermissionService;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAllowPermissionService() {
        return allowPermissionService;
    }

    public void setAllowPermissionService(List<String> allowPermissionService) {
        this.allowPermissionService = allowPermissionService;
    }
}
