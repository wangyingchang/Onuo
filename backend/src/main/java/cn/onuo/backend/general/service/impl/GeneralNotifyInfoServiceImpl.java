package cn.onuo.backend.general.service.impl;

import cn.onuo.backend.general.dao.GeneralNotifyInfoMapper;
import cn.onuo.backend.general.model.GeneralNotifyInfo;
import cn.onuo.backend.general.service.GeneralNotifyInfoService;
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
public class GeneralNotifyInfoServiceImpl extends AbstractService<GeneralNotifyInfo> implements GeneralNotifyInfoService {
    @Resource
    private GeneralNotifyInfoMapper generalNotifyInfoMapper;
    @Override
    public GeneralNotifyInfo getNotifyInfoByNotifyId(String notifyId) {
        return generalNotifyInfoMapper.selectNotifyInfoByNotifyId(notifyId);
    }

    @Override
    public List<GeneralNotifyInfo> getAllNotifyInfo() {
        return generalNotifyInfoMapper.selectAllNotifyInfo();
    }


}
