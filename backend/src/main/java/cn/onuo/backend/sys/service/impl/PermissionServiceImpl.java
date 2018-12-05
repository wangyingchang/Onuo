package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.PermissionMapper;
import cn.onuo.backend.sys.model.Permission;
import cn.onuo.backend.sys.service.PermissionService;
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
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

}
