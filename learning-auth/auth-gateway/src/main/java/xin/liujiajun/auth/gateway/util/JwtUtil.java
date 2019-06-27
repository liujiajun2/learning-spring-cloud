package xin.liujiajun.auth.gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;
import xin.liujiajun.auth.gateway.exception.PermissionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author LiuJiaJun
 * @date 2019/6/27 19:30
 */
public class JwtUtil {

    public final static String SECRET = "qazwsx123444$#%#()*&& asdaswwi1235 ?;!@#kmmmpom in***xx**&";
    public final static String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_AUTH = "Authorization";

    public static String generateToken(String user){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",new Random().nextInt());
        map.put("user",user);
        String jwt = Jwts.builder()
                .setSubject("user info").setClaims(map)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        return TOKEN_PREFIX + " " + jwt;

    }

    public static Map<String,String> validateToken(String token) {
        if (token != null) {
            HashMap<String, String> map = new HashMap<>();
            Map<String,Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String id = String.valueOf(body.get("id"));
            String user = (String) body.get("user");
            map.put("id",id);
            map.put("user",user);
            if (StringUtils.isEmpty(user)) {
                throw new PermissionException("user is error,please check");
            }
            return map;
        }else{
            throw new PermissionException("token is error,please check");
        }
    }
}
