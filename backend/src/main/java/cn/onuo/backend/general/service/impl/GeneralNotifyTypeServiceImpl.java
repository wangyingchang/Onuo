package cn.onuo.backend.general.service.impl;

import cn.onuo.backend.general.dao.GeneralNotifyTypeMapper;
import cn.onuo.backend.general.model.GeneralNotifyType;
import cn.onuo.backend.general.service.GeneralNotifyTypeService;
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
public class GeneralNotifyTypeServiceImpl extends AbstractService<GeneralNotifyType> implements GeneralNotifyTypeService {
    @Resource
    private GeneralNotifyTypeMapper generalNotifyTypeMapper;

}
