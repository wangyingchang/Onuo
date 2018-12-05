package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.SysLogMapper;
import cn.onuo.backend.sys.model.SysLog;
import cn.onuo.backend.sys.service.SysLogService;
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
public class SysLogServiceImpl extends AbstractService<SysLog> implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

}
