package cn.tedu.cppfoto.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


@Component
public class MyUtils {
    /*
     * 将一个字符串MD5加密，方式很多，我们使用的是Spring包下
     */
    public static String getMd5Simple(String password){
        String md502 = DigestUtils.md5DigestAsHex(password.getBytes());
        return md502;
    }
    public static String getMd5(String password){
        /*
         * 原密码加密一次
         * 获取原密码加密后前8位字符
         * 8位字符+加密后的字符串    再加密一次
         */
        String md501= DigestUtils.md5DigestAsHex(password.getBytes());
        String temp =md501.substring(0, 8);
        String md502 =DigestUtils.md5DigestAsHex((temp+md501).getBytes());
        return md502;
    }
}
