package com.lc.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * shiro 自定义 Realm 加入 使用MD5 + salt处理 + hash散列
 * 自定义realm实现 将认证/授权数据的来源转为数据库的实现
 */
public class DiyShiroUsersRealmWithMD5AndSaltAndHash extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        System.out.println(principal); // shviplc
        // 根据身份信息使用jdbc mybatis mybatisplus查询相关数据库
        if ("shviplc".equals(principal)) {
            // 参数1:返回数据库正确的用户名 参数2:返回数据库正确的密码 参数3:提供当前Realm的名字 this.getName()

            // 使用MD5
            // SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("shviplc", "47c4914cdce62e9ae1e8d079deefd47c", this.getName());

            // 使用MD5 + salt
            //    SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,
            //            "a798559fb21516c2b79c7cc24a905bf6",
            //            ByteSource.Util.bytes("X0*7ps"),
            //            this.getName());

            // 使用MD5 + salt + Hash散列 在testShiroDiyRealmAndMD5AndSaltAndHash中指定散列次数为1024即可 现在的测试类停留在这个
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,
                    "05b46141eb2dd2c09961e47db7671d4c",
                    ByteSource.Util.bytes("X0*7ps"),
                    this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}