package com.yinfeng.wms.mapper;

import com.yinfeng.wms.domain.Permissions;
import com.yinfeng.wms.domain.Role;
import com.yinfeng.wms.domain.User;

import java.util.Set;

/**
 * @author jonas
 * @time 2020 07 11 10 45
 * @description: wms
 */
public interface UserMapper {
    User getUserByName(String name);

    Set<Role> getRolesByIds(String[] roleIds);

    Set<Permissions> getPermissionsByIds(String[] permissions);

    User getUserVerifyByName(String name);
}
