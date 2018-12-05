package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.SysMenuMapper;
import cn.onuo.backend.sys.model.SysMenu;
import cn.onuo.backend.sys.service.SysMenuService;
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
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

}
