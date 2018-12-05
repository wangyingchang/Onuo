package cn.onuo.backend.car.service.impl;

import cn.onuo.backend.car.dao.CarMaintainMapper;
import cn.onuo.backend.car.model.CarMaintain;
import cn.onuo.backend.car.service.CarMaintainService;
import cn.onuo.backend.common.service.AbstractService;
import cn.onuo.backend.common.utils.IdGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Manba
 * @date 2018/10/02.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class CarMaintainServiceImpl extends AbstractService<CarMaintain> implements CarMaintainService {
    @Resource
    private CarMaintainMapper carMaintainMapper;


    @Override
    public int addCarMaintain(CarMaintain carMaintain) {
        carMaintain.setMaintainId(IdGenerator.getNewUserId());
        this.save(carMaintain);
        return 1;
    }
}
