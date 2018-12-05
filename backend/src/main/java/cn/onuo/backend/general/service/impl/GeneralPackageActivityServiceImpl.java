package cn.onuo.backend.general.service.impl;

import cn.onuo.backend.general.dao.GeneralPackageActivityMapper;
import cn.onuo.backend.general.model.GeneralPackageActivity;
import cn.onuo.backend.general.service.GeneralPackageActivityService;
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
public class GeneralPackageActivityServiceImpl extends AbstractService<GeneralPackageActivity> implements GeneralPackageActivityService {
    @Resource
    private GeneralPackageActivityMapper generalPackageActivityMapper;

}
