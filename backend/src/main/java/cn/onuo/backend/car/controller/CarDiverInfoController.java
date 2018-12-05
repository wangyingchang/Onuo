package cn.onuo.backend.car.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.car.model.CarDiverInfo;
import cn.onuo.backend.car.service.CarDiverInfoService;
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
@RequestMapping("/car/diver/info")
public class CarDiverInfoController {
    @Resource
    private CarDiverInfoService carDiverInfoService;

    /**
     * 添加驾驶证信息
     * @param carDiverInfo 驾驶证信息
     * @return
     */
    @PostMapping("/addDriverInfo")
    public JsonResult add(@RequestBody CarDiverInfo carDiverInfo) {
        carDiverInfo.setId(IdGenerator.getNewUserId());
        int result = carDiverInfoService.saveDriverInfo(carDiverInfo);
        return JsonResultGenerator.genSuccessResult(result);
    }


    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable String id) {
        carDiverInfoService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody CarDiverInfo carDiverInfo) {
        carDiverInfoService.update(carDiverInfo);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable String id) {
        CarDiverInfo carDiverInfo = carDiverInfoService.findById(id);
        return JsonResultGenerator.genSuccessResult(carDiverInfo);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CarDiverInfo> list = carDiverInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findByDriverId")
    public JsonResult findDriverInfo(@RequestParam String diverId) {
        CarDiverInfo carDiverInfo = carDiverInfoService.findByDriverId(diverId);
        return JsonResultGenerator.genSuccessResult(carDiverInfo);
    }






}
