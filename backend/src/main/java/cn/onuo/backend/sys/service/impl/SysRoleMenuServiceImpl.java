package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.SysRoleMenuMapper;
import cn.onuo.backend.sys.model.SysRoleMenu;
import cn.onuo.backend.sys.service.SysRoleMenuService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author kaikai
* @date 2018/10/02.
*/
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class SysRoleMenuServiceImpl extends AbstractService<SysRoleMenu> implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

}
