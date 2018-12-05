package cn.onuo.backend.car.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.car.model.CarDiscountActivity;
import cn.onuo.backend.car.service.CarDiscountActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

/**
 * @author kaikai
 * @date 2018/10/02.
 */
@RestController
@RequestMapping("/car/discount/activity")
public class CarDiscountActivityController {
    @Resource
    private CarDiscountActivityService carDiscountActivityService;

    @PostMapping
    public JsonResult add(@RequestBody CarDiscountActivity carDiscountActivity) {
        carDiscountActivityService.save(carDiscountActivity);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        carDiscountActivityService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody CarDiscountActivity carDiscountActivity) {
        carDiscountActivityService.update(carDiscountActivity);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        CarDiscountActivity carDiscountActivity = carDiscountActivityService.findById(id);
        return JsonResultGenerator.genSuccessResult(carDiscountActivity);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CarDiscountActivity> list = carDiscountActivityService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 优惠活动推荐
     * 查询出长期租赁的车辆信息，需要查询出车辆星级评价
     */
    @GetMapping("/recommendLongActivityCar")
    public JsonResult recommendLongActivityCar(){
        List<CarDiscountActivity> carDiscountActivityList = carDiscountActivityService.recommendLongActivityCar();
        return JsonResultGenerator.genSuccessResult(carDiscountActivityList);
    }

    /**
     * 优惠活动推荐
     * 查询出具有优惠活动的车辆，需要查询出车辆星级评价
     * @return
     */
    @GetMapping("/allActivityCar")
    public JsonResult allActivityCar(){
        List<CarDiscountActivity> carDiscountActivityList = carDiscountActivityService.allActivityCar();
        return JsonResultGenerator.genSuccessResult(carDiscountActivityList);
    }

    /**
     * 优惠套餐推荐
     * @return
     */
    @GetMapping("/discountPackage")
    public JsonResult discountPackage(){
        List<CarDiscountActivity> carDiscountActivityList = carDiscountActivityService.discountPackage();
        return JsonResultGenerator.genSuccessResult(carDiscountActivityList);
    }

    @GetMapping("/allActivityCar/withTime")
    public JsonResult allActivityCarWithTime(@RequestParam String beginTime,@RequestParam String endTime) throws ParseException {

        java.text.SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = format.parse(beginTime);
        Date endDate = format.parse(endTime);
        List<CarDiscountActivity> carDiscountActivityList = carDiscountActivityService.allActivityCarWithTime(beginDate,endDate);
        return JsonResultGenerator.genSuccessResult(carDiscountActivityList);
    }


}
