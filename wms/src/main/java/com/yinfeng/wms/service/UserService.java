package com.yinfeng.wms.service;

import com.yinfeng.wms.domain.Permissions;
import com.yinfeng.wms.domain.Role;
import com.yinfeng.wms.domain.User;
import com.yinfeng.wms.mapper.UserMapper;
import com.yinfeng.wms.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author jonas
 * @time 2020 07 11 10 54
 * @description: wms
 */
@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public User getUserInfoByName(String name) {
        User user = userMapper.getUserByName(name);
        String[] roleIds = user.getRole().split(",");
        Set<Role> roles = userMapper.getRolesByIds(roleIds);
        System.out.println(roles);
        for (Role r :
                roles) {
            System.out.println(r);
            String[] permissions = r.getPermission().split(",");
            Set<Permissions> permissionsSet = userMapper.getPermissionsByIds(permissions);
            r.setPermissions(permissionsSet);
        }
        user.setRoles(roles);
        return user;
    }

    public User getUserVerifyByName(String name){
        return userMapper.getUserVerifyByName(name);
    }


    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
    private User getMapByName(String userName){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permissions permissions1 = new Permissions("1","query");
        Permissions permissions2 = new Permissions("2","add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        Role role = new Role("1","admin",permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User(1,"wsl","123456",roleSet);
        Map<String ,User> map = new HashMap<>();
        map.put(user.getName(), user);

        Permissions permissions3 = new Permissions("3","query");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role role1 = new Role("2","user",permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User(1,"zhangsan","123456",roleSet1);
        map.put(user1.getName(), user1);
        return map.get(userName);
    }
}
