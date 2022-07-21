package com.chen.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Utils {

    private static final String salt = "1a2b3c4d";


    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    /**
     * 第一次加密
     * @param inputPass
     * @return
     */
    public static String inputPassToFromPass(String inputPass){
        String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * 第二次加密
     * @param fromPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String fromPass,String salt){
        String str = salt.charAt(0) + salt.charAt(2) + fromPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass,String salt){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass,salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(formPassToDBPass("ce21b747de5af71ab5c2e20ff0a60eea","1a2b3c4d"));
        System.out.println(inputPassToDbPass("123456","1a2b3c4d"));
    }

}
