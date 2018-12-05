package cn.onuo.backend.car.service;

import cn.onuo.backend.car.model.CarInsuranceInfo;
import cn.onuo.backend.common.service.Service;

/**
 * @author Manba
 * @date 2018/10/02.
 */
public interface CarInsuranceInfoService extends Service<CarInsuranceInfo> {

    /**
     * 录入车辆保养信息
     * @param carInsuranceInfo 车辆保险信息
     * @return 返回1
     */
    int addCarInsurance(CarInsuranceInfo carInsuranceInfo);
}
