package cn.onuo.backend.car.service.impl;

import cn.onuo.backend.car.dao.CarDiverInfoMapper;
import cn.onuo.backend.car.model.CarDiverInfo;
import cn.onuo.backend.car.service.CarDiverInfoService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class CarDiverInfoServiceImpl extends AbstractService<CarDiverInfo> implements CarDiverInfoService {
    @Resource
    private CarDiverInfoMapper carDiverInfoMapper;

    @Override
    public int saveDriverInfo(CarDiverInfo carDiverInfo) {
            Condition condition=new Condition(CarDiverInfo.class);
            Example.Criteria criteria= condition.createCriteria();
            criteria.andEqualTo("diverId",carDiverInfo.getDiverId());
            List<CarDiverInfo> lists= this.findByCondition(condition);
            if (lists!=null&&lists.size()>0){
                return 1;
            }
            this.save(carDiverInfo);
            return 1;
    }

    @Override
    public CarDiverInfo findByDriverId(String diverId) {
        Condition condition = new Condition(CarDiverInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("diverId",diverId);
        List<CarDiverInfo> list = this.findByCondition(condition);
        if (null!=list&&list.size()>0){
            return list.get(0);
        }
        return null;

    }
}
