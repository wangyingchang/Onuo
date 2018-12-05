package cn.onuo.backend.car.service.impl;

import cn.onuo.backend.car.dao.CarBrandMapper;
import cn.onuo.backend.car.model.CarBrand;
import cn.onuo.backend.car.service.CarBrandService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class CarBrandServiceImpl extends AbstractService<CarBrand> implements CarBrandService {
    @Resource
    private CarBrandMapper carBrandMapper;
    @Override
    public List<String> carBrandIds(String carBrand) {
        List<String> brandIds=new ArrayList<>();
        if (!"0".equals(carBrand)){
            String[] brands=carBrand.split(",");
            List<String> brandsList= Arrays.asList(brands);
            Condition condition=new Condition(CarBrand.class);
            Example.Criteria criteria=condition.createCriteria();
            criteria.andIn("brandName",brandsList);
            List<CarBrand> carBrands= this.findByCondition(condition);
            for (CarBrand entity : carBrands){
                brandIds.add(entity.getBrandId());
            }
        }
        return brandIds;
    }

}
