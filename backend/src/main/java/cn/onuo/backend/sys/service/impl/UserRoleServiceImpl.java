package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.UserRoleMapper;
import cn.onuo.backend.sys.model.UserRole;
import cn.onuo.backend.sys.service.UserRoleService;
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
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

}
