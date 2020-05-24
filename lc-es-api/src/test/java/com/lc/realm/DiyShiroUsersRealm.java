package com.lc.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * shiro 自定义 Realm
 * 自定义realm实现 将认证/授权数据的来源转为数据库的实现
 */
public class DiyShiroUsersRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        System.out.println(principal);
        // 根据身份信息使用jdbc mybatis mybatisplus查询相关数据库
        if ("ahviplc".equals(principal)) {
            // 参数1:返回数据库正确的用户名 参数2:返回数据库正确的密码 参数3:提供当前Realm的名字 this.getName()
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("ahviplc", "ahviplc", this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
