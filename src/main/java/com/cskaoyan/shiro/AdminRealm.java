/*
package com.cskaoyan.shiro;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.AdminExample;
import com.cskaoyan.bean.Permission;
import com.cskaoyan.bean.PermissionExample;
import com.cskaoyan.mapper.AdminMapper;
import com.cskaoyan.mapper.PermissionMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*/
/**
 * Created by 张凡 on 2020/5/5 12:56
 *//*

@Component
public class AdminRealm extends AuthorizingRealm {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        MallToken token= (MallToken) authenticationToken;
        String username=token.getUsername();
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andDeletedEqualTo(false).andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins==null){
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(admins.get(0), admins.get(0).getPassword(), this.getName());
        return simpleAuthenticationInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Admin admin = (Admin) principalCollection.getPrimaryPrincipal();
        Integer[] roleIds = admin.getRoleIds();
        List<Integer> roleIdList = Arrays.asList(roleIds);
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.setDistinct(true);
        permissionExample.or().andDeletedEqualTo(false).andRoleIdIn(roleIdList);
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        ArrayList<String> strings = new ArrayList<>();
        if(permissions!=null){
            for (Permission permission : permissions) {
                strings.add(permission.getPermission());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(strings);
        return simpleAuthorizationInfo;
    }


}
*/
