package com.gl.hotel.cookie;

import java.util.HashMap;

public class PasswordClass {

    public static HashMap<String, String> passwordMap = new HashMap<String, String>();

    static {
        passwordMap.put("zhangsan", "123");
        passwordMap.put("lisi", "456");
        passwordMap.put("wangwu", "789");
    }

    public static void registerUser(String username, String password) {
        passwordMap.put(username, password);
    }

    public static boolean verify(String username, String password) {
        String p = passwordMap.get(username);
        if (p == null) {
            return false;
        }
        return p.equals(password);
    }

}
