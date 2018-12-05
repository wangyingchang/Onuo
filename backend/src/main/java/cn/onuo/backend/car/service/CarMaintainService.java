package cn.onuo.backend.car.service;

import cn.onuo.backend.car.model.CarMaintain;
import cn.onuo.backend.common.service.Service;

/**
 * @author Manba
 * @date 2018/10/02.
 */
public interface CarMaintainService extends Service<CarMaintain> {

    /**
     * 录入车辆保养信息
     * @param carMaintain 车辆保养信息
     * @return 返回1
     */
    int addCarMaintain(CarMaintain carMaintain);
}
