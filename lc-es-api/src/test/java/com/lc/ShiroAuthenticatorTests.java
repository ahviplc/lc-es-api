package com.lc;

import com.lc.realm.DiyShiroUsersRealm;
import com.lc.realm.DiyShiroUsersRealmWithMD5AndSaltAndHash;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShiroAuthenticatorTests {

    @Test
    void testShiro() {
        System.out.println("========================= test Shiro ========================= ");
        // 1.创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        // 2.给安全管理器设置realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        // 3. SecurityUtils 给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        // 4.关键对象 Subject 主体
        Subject subject = SecurityUtils.getSubject();

        // 5. 创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("lc", "lc");

        try {
            System.out.println("认证状态: " + subject.isAuthenticated());
            subject.login(token); //用户认证
            System.out.println("认证状态: " + subject.isAuthenticated());
            System.out.println("认证登录成功");
        } catch (UnknownAccountException e) {
            System.out.println("认证失败: 用户不存在");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            System.out.println("认证失败: 密码错误");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    //自定义 Realm DiyShiroUsersRealm 测试
    @Test
    void testShiroDiyRealm() {
        System.out.println("========================= test Shiro ========================= ");
        // 1.创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        // 2.给安全管理器设置realm
        securityManager.setRealm(new DiyShiroUsersRealm());

        // 3. SecurityUtils 给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        // 4.关键对象 Subject 主体
        Subject subject = SecurityUtils.getSubject();

        // 5. 创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("ahviplc", "ahviplc");

        try {
            System.out.println("认证状态: " + subject.isAuthenticated());
            subject.login(token); //用户认证
            System.out.println("认证状态: " + subject.isAuthenticated());
            System.out.println("认证登录成功");
        } catch (UnknownAccountException e) {
            System.out.println("认证失败: 用户不存在");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            System.out.println("认证失败: 密码错误");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    //自定义 Realm和使用MD5 + salt处理 + hash散列 测试
    @Test
    void testShiroDiyRealmAndMD5AndSaltAndHash() {
        System.out.println("========================= test Shiro ========================= ");
        // 1.创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        // 2.给安全管理器设置realm 注入realm
        DiyShiroUsersRealmWithMD5AndSaltAndHash realm = new DiyShiroUsersRealmWithMD5AndSaltAndHash();

        // 设置realm使用hash凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 使用算法
        credentialsMatcher.setHashAlgorithmName("md5"); // 使用MD5
        // 散列次数 测试使用MD5 + salt + Hash散列时加上 默认为散列次数为1 如不测试 三种一起【使用MD5 + salt + Hash散列时】的 隐掉下一行代码或者将其改为1即可
        credentialsMatcher.setHashIterations(1024); //散列次数置成1024
        // credentialsMatcher.setHashIterations(1); //默认散列次数为1

        // 将hash凭证匹配器置入realm
        realm.setCredentialsMatcher(credentialsMatcher);
        // 将realm置入安全管理器对象securityManager
        securityManager.setRealm(realm);

        // 3. SecurityUtils 给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        // 4.关键对象 Subject 主体
        Subject subject = SecurityUtils.getSubject();

        // 5. 创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("shviplc", "shviplc");

        try {
            System.out.println("认证状态: " + subject.isAuthenticated());
            subject.login(token); //用户认证
            System.out.println("认证状态: " + subject.isAuthenticated());
            System.out.println("认证登录成功");
        } catch (UnknownAccountException e) {
            System.out.println("认证失败: 用户不存在");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            System.out.println("认证失败: 密码错误");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
