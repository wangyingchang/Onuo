package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.RoleMapper;
import cn.onuo.backend.sys.model.Role;
import cn.onuo.backend.sys.service.RoleService;
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
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

}
