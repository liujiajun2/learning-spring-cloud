package xin.liujiajun.auth.gateway.exception;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 19:44
 */
public class PermissionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PermissionException(String msg) {
        super(msg);
    }
}
