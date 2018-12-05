package cn.onuo.backend.car.service.impl;

import cn.onuo.backend.car.dao.CarInsuranceInfoMapper;
import cn.onuo.backend.car.model.CarInsuranceInfo;
import cn.onuo.backend.car.service.CarInsuranceInfoService;
import cn.onuo.backend.common.service.AbstractService;
import cn.onuo.backend.common.utils.IdGenerator;
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
public class CarInsuranceInfoServiceImpl extends AbstractService<CarInsuranceInfo> implements CarInsuranceInfoService {
    @Resource
    private CarInsuranceInfoMapper carInsuranceInfoMapper;

    @Override
    public int addCarInsurance(CarInsuranceInfo carInsuranceInfo) {
        carInsuranceInfo.setInsuranceId(IdGenerator.getNewUserId());
        this.save(carInsuranceInfo);
        return 1;
    }
}
