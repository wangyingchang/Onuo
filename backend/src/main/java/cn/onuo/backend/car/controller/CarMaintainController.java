package cn.onuo.backend.car.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.car.model.CarMaintain;
import cn.onuo.backend.car.service.CarMaintainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kaikai
 * @date 2018/10/02.
 */
@RestController
@RequestMapping("/car/maintain")
public class CarMaintainController {
    @Resource
    private CarMaintainService carMaintainService;

    /**
     * 录入车辆保养信息
     * @param carMaintain 车辆保养信息
     * @return 返回JsonResult
     */
    @PostMapping
    public JsonResult add(@RequestBody CarMaintain carMaintain) {
        int result = carMaintainService.addCarMaintain(carMaintain);
        return JsonResultGenerator.genSuccessResult(result);
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        carMaintainService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody CarMaintain carMaintain) {
        carMaintainService.update(carMaintain);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        CarMaintain carMaintain = carMaintainService.findById(id);
        return JsonResultGenerator.genSuccessResult(carMaintain);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CarMaintain> list = carMaintainService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
