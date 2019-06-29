package com.bootdo.realm;

import com.bootdo.common.enums.UserEnum;
import com.bootdo.common.util.ShiroUtil;
import com.bootdo.domain.system.dto.UserDTO;
import com.bootdo.domain.system.query.UserVOQuery;
import com.bootdo.mapper.system.UserMapper;
import com.bootdo.service.system.MenuService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Set;

/**
 * @Author: lihq
 * @Date: 2019/6/25 16:13
 * @Description:
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuService menuService;
    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 1. 获取输入的用户名, 密码
        String username =(String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        //2. 组装参数 查询用户信息
        UserVOQuery query = new UserVOQuery();
        query.setUsername(username);
        query.setPassword(password);
        List<UserDTO> dtoList = userMapper.queryUser(query);

        //3. 用户校验
        UserDTO user = null;
        if (dtoList == null || dtoList.size() == 0) {
            throw new UnknownAccountException(UserEnum.UNKNOW_ACCOUNT.getMessage());
        } else {
            user = dtoList.get(0);
            if (!user.getPassword().equals(password)) {
                throw new IncorrectCredentialsException(UserEnum.INCORRENT_PASSWORD.getMessage());
            }
            if (0 == user.getStatus()) {
                throw new LockedAccountException(UserEnum.ACCOUNT_LOCK.getMessage());
            }
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, this.getName());
        return info;
    }

    
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Long userId = ShiroUtil.getUserId();
        Set<String> perms = menuService.listPerms(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;
    }


}
