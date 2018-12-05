package cn.onuo.backend.sys.dao;

import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.sys.model.Permission;

import java.util.List;

/**
 * @author kaikai
 * @date 2018/09/30.
 */
public interface PermissionMapper extends MyMapper<Permission> {
    List<String> findAllPermCode();
}