package cn.onuo.backend.car.service;

import cn.onuo.backend.car.model.CarDiscountActivity;
import cn.onuo.backend.common.service.Service;

import java.util.Date;
import java.util.List;

/**
 * @author kaikai
 * @date 2018/10/02.
 */
public interface CarDiscountActivityService extends Service<CarDiscountActivity> {

    /**
     * 查询出长期租赁的车辆信息，需要查询出车辆星级评价
     * @return
     */
    List<CarDiscountActivity> recommendLongActivityCar();

    /**
     * 查询出具有优惠活动的车辆，需要查询出车辆星级评价
     * @return
     */
    List<CarDiscountActivity> allActivityCar();

    /**
     * 查询出具有优惠套餐的车辆,需要查询出车辆的星级评价
     * @return
     */
    List<CarDiscountActivity> discountPackage();


    List<CarDiscountActivity> allActivityCarWithTime(Date beginTime, Date endTime);


}
