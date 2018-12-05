package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.RolePermissionMapper;
import cn.onuo.backend.sys.model.RolePermission;
import cn.onuo.backend.sys.service.RolePermissionService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author kaikai
* @date 2018/09/30.
*/
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class RolePermissionServiceImpl extends AbstractService<RolePermission> implements RolePermissionService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;

}
