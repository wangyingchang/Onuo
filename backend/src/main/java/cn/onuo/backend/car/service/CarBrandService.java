package cn.onuo.backend.car.service;

import cn.onuo.backend.car.model.CarBrand;
import cn.onuo.backend.common.service.Service;

import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
public interface CarBrandService extends Service<CarBrand> {
    List<String> carBrandIds(String carBrand);
}
