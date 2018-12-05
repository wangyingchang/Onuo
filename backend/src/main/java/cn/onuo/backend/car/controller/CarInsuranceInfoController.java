package cn.onuo.backend.car.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.car.model.CarInsuranceInfo;
import cn.onuo.backend.car.service.CarInsuranceInfoService;
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
@RequestMapping("/car/insurance/info")
public class CarInsuranceInfoController {
    @Resource
    private CarInsuranceInfoService carInsuranceInfoService;

    /**
     * 录入车辆保险信息
     * @param carInsuranceInfo 车辆保险信息
     * @return 返回JsonResult
     */
    @PostMapping
    public JsonResult add(@RequestBody CarInsuranceInfo carInsuranceInfo) {
        int result = carInsuranceInfoService.addCarInsurance(carInsuranceInfo);
        return JsonResultGenerator.genSuccessResult(result);
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        carInsuranceInfoService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody CarInsuranceInfo carInsuranceInfo) {
        carInsuranceInfoService.update(carInsuranceInfo);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        CarInsuranceInfo carInsuranceInfo = carInsuranceInfoService.findById(id);
        return JsonResultGenerator.genSuccessResult(carInsuranceInfo);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CarInsuranceInfo> list = carInsuranceInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
