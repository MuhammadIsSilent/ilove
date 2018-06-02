package cn.ljzyemu.iloveweb.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.tomcat.util.http.parser.Authorization;

import java.util.Set;

/**
 * @Author :ljz
 * @Date :2018/5/22  10:59
 **/
public class ShiroRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principals = subject.getPrincipals();  //   获取用户信息

        Session session = subject.getSession();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        UsernamePasswordToken userToken = new UsernamePasswordToken("",""); // 记住我
//        userToken.setRememberMe(true); //记住我
        String username = usernamePasswordToken.getUsername();
        char[] password = usernamePasswordToken.getPassword();
        ByteSource byteSource = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, byteSource, getName());

        return simpleAuthenticationInfo;
    }
}
