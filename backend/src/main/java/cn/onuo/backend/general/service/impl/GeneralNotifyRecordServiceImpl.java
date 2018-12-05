package cn.onuo.backend.general.service.impl;

import cn.onuo.backend.general.dao.GeneralNotifyRecordMapper;
import cn.onuo.backend.general.model.GeneralNotifyRecord;
import cn.onuo.backend.general.service.GeneralNotifyRecordService;
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
public class GeneralNotifyRecordServiceImpl extends AbstractService<GeneralNotifyRecord> implements GeneralNotifyRecordService {
    @Resource
    private GeneralNotifyRecordMapper generalNotifyRecordMapper;

}
