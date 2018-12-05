package cn.onuo.backend.sys.dao;

import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.sys.model.Permission;
import cn.onuo.backend.sys.model.Role;
import cn.onuo.backend.sys.model.User;

import java.util.List;

/**
 * @author kaikai
 * @date 2018/09/30.
 */
public interface UserMapper extends MyMapper<User> {
    User findUserByUserName(String username);
    List<Role> findRolesByUserId(String id);
    List<Permission> findPermissionsByRoleId(String id);
    User findUserByUserId(String id);
}