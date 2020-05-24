package com.lc.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * shiro中MD5的实现
 */
public class ShiroMD5Utils {
    public static void main(String[] args) {
        // 创建一个md5算法
        //    Md5Hash md5Hash = new Md5Hash();
        //    md5Hash.setBytes("shviplc".getBytes());
        //    String toHex = md5Hash.toHex();
        //    System.out.println(toHex); // 73687669706c63

        // 使用md5
        Md5Hash md5Hash = new Md5Hash("shviplc");
        System.out.println(md5Hash.toHex()); // 47c4914cdce62e9ae1e8d079deefd47c

        // 使用MD5 + salt处理
        Md5Hash md5Hash1 = new Md5Hash("shviplc", "X0*7ps");
        System.out.println(md5Hash1); // a798559fb21516c2b79c7cc24a905bf6

        // 使用MD5 + salt处理 + hash散列
        Md5Hash md5Hash2 = new Md5Hash("shviplc", "X0*7ps", 1024);
        System.out.println(md5Hash2); // 05b46141eb2dd2c09961e47db7671d4c
    }
}
