package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.SysAreaMapper;
import cn.onuo.backend.sys.model.SysArea;
import cn.onuo.backend.sys.service.SysAreaService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class SysAreaServiceImpl extends AbstractService<SysArea> implements SysAreaService {
    @Resource
    private SysAreaMapper sysAreaMapper;
    @Override
    public List<String> queryAreaByCity(String city) {
        return sysAreaMapper.queryAreaByCity(city);
    }
}
