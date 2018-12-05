package cn.onuo.backend.car.dao;

import cn.onuo.backend.car.model.CarDiscountActivity;
import cn.onuo.backend.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author kaikai
 */
public interface CarDiscountActivityMapper extends MyMapper<CarDiscountActivity> {


    /**
     * 长租优惠车型推荐
     * @return
     */
    List<CarDiscountActivity> recommendLongActivityCar();

    /**
     * 优惠活动车型推荐
     * @return
     */
    List<CarDiscountActivity> allActivityCar();

    /**
     * 优惠套餐推荐
     * @return
     */
    List<CarDiscountActivity> discountPackage();

    List<CarDiscountActivity> allActivityCarWithTime(@Param("beginTime") Date beginTime, @Param("endTime")Date endTime);
}