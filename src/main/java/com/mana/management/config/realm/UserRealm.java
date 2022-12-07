package com.mana.management.config.realm;
import com.mana.management.config.JWTToken;
import com.mana.management.config.utils.JWTUtils;
import com.mana.management.dao.RoleDao;
import com.mana.management.pojo.Role;
import com.mana.management.pojo.User;
import com.mana.management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    UserService userService;
    @Resource
    RoleDao roleDao;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("用户授权...");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        Role role = roleDao.selectByPrimaryKey(user.getRoleId());
        authorizationInfo.addRole(role.getName());
        authorizationInfo.addStringPermission(null);
        return authorizationInfo;
    }

    //认证
    @Override
    //我们在doGetAuthenticationInfo方法内部是需要查询数据库操作的
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("用户认证...");
        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtils.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token异常");
        }
        User userBean = userService.findByUsername(username);
        if (!JWTUtils.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("密码错误");
        }
        return new SimpleAuthenticationInfo(userBean, token, getName());
    }
}
