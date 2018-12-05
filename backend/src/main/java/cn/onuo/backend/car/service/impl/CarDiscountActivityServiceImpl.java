package cn.onuo.backend.car.service.impl;

import cn.onuo.backend.car.dao.CarDiscountActivityMapper;
import cn.onuo.backend.car.model.CarDiscountActivity;
import cn.onuo.backend.car.service.CarDiscountActivityService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author kaikai
 * @date 2018/10/02.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class CarDiscountActivityServiceImpl extends AbstractService<CarDiscountActivity> implements CarDiscountActivityService {
    @Resource
    private CarDiscountActivityMapper carDiscountActivityMapper;
    @Override
    public List<CarDiscountActivity> recommendLongActivityCar() {

        List<CarDiscountActivity> carDiscountActivityList=carDiscountActivityMapper.recommendLongActivityCar();
        return carDiscountActivityList;
    }

    @Override
    public List<CarDiscountActivity> allActivityCar() {
        List<CarDiscountActivity> carDiscountActivityList=carDiscountActivityMapper.allActivityCar();
        return carDiscountActivityList;
    }

    @Override
    public List<CarDiscountActivity> discountPackage() {
        List<CarDiscountActivity> carDiscountActivityList=carDiscountActivityMapper.discountPackage();
        return carDiscountActivityList;
    }
    @Override
    public List<CarDiscountActivity> allActivityCarWithTime(Date beginTime, Date endTime) {
        List<CarDiscountActivity> carDiscountActivityList=carDiscountActivityMapper.allActivityCarWithTime(beginTime,endTime);
        return carDiscountActivityList;
    }


}
