package cn.onuo.backend.general.service.impl;

import cn.onuo.backend.general.dao.GeneralPackageCarMapper;
import cn.onuo.backend.general.model.GeneralPackageCar;
import cn.onuo.backend.general.service.GeneralPackageCarService;
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
public class GeneralPackageCarServiceImpl extends AbstractService<GeneralPackageCar> implements GeneralPackageCarService {
    @Resource
    private GeneralPackageCarMapper generalPackageCarMapper;

}
