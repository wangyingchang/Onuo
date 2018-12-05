package cn.onuo.backend.car.service;

import cn.onuo.backend.car.model.CarDiverInfo;
import cn.onuo.backend.common.service.Service;

/**
* @author kaikai
* @date 2018/10/02.
*/
public interface CarDiverInfoService extends Service<CarDiverInfo> {

    int saveDriverInfo(CarDiverInfo carDiverInfo);

    /**
     * 根据驾驶证id查询
     * @param driverId
     * @return
     */
    CarDiverInfo findByDriverId(String diverId);
}
