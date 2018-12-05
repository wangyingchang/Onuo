package cn.onuo.backend.car.controller;

import cn.onuo.backend.car.service.CarBrandService;
import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.car.model.CarInfo;
import cn.onuo.backend.car.service.CarInfoService;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import cn.onuo.backend.general.service.GeneralImageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Time
 * @date 2018/10/13
 */
@RestController
@RequestMapping("/car/info")
public class CarInfoController {

    @Resource
    private CarInfoService carInfoService;
    @Resource
    private GeneralImageService generalImageService;
    @Resource
    private CarBrandService carBrandService;

    /**
     * 查询出所有的车辆类型
     * @return 车辆的所有类型
     */
    @GetMapping("/carType")
    public JsonResult queryCarType(){
        return JsonResultGenerator.genSuccessResult(carInfoService.queryCarType());
    }

    /**
     * 查询出所有的车辆品牌
     * @return 车辆的所有品牌
     */
    @GetMapping("/carBrand")
    public JsonResult queryCarBrand(){
        return JsonResultGenerator.genSuccessResult(carInfoService.queryCarBrand());
    }

    /**
     * 检索所有车辆
     * @return 车辆信息
     */
    @GetMapping("/all")
    public JsonResult queryCarByAll(){
        return JsonResultGenerator.genSuccessResult(carInfoService.queryCarByAll());
    }

    /**
     * 根据车型检索车辆
     * @param carType 车辆类型
     * @return 车辆信息
     */
    @GetMapping("/carType/{carType}")
    public JsonResult queryCarByType(@PathVariable String carType){
        return JsonResultGenerator.genSuccessResult(carInfoService.queryCarByType(carType));
    }

    /**
     * 根据车购价检索车辆
     * @param startCarPrice 起始价
     * @param endCarPrice 尾价
     * @return 车辆信息
     */
    @GetMapping("/price/{startCarPrice}&{endCarPrice}")
    public JsonResult queryCarByPrice( @PathVariable String startCarPrice,@PathVariable String endCarPrice){
        List<Map<String,String>> list=carInfoService.queryCarByPrice(Double.parseDouble(startCarPrice),Double.parseDouble(endCarPrice));
        return JsonResultGenerator.genSuccessResult(list);
    }

    /**
     * 根据租价检索车辆
     * @param startCarRent 起始租金
     * @param endCarRent 尾租金
     * @return 车辆信息
     */
    @GetMapping("/rent/{startCarRent}&{endCarRent}")
    public JsonResult queryCarByRent(@PathVariable String startCarRent,@PathVariable String endCarRent){
        List<Map<String,String>> list=carInfoService.queryCarByRent(Integer.parseInt(startCarRent),Integer.parseInt(endCarRent));
        return JsonResultGenerator.genSuccessResult(list);
    }

    /**
     * 根据车辆品牌名检索车辆
     * @param brandName 车辆品牌名
     * @return 车辆信息
     */
    @GetMapping("/brand/{brandName}")
    public JsonResult queryCarByBrand(@PathVariable String brandName){
        return JsonResultGenerator.genSuccessResult(carInfoService.queryCarByBrand(brandName));
    }

    /**
     * 根据车辆座位数检索车辆
     * @param startCarSeat 座位数范围开始
     * @param endCarSeat 座位数范围结束
     * @return 车辆信息
     */
    @GetMapping("/seat/{startCarSeat}&{endCarSeat}")
    public JsonResult queryCarBySeat(@PathVariable String startCarSeat,@PathVariable String endCarSeat){
        List<Map<String,String>> list=carInfoService.queryCarBySeat(Integer.parseInt(startCarSeat),Integer.parseInt(endCarSeat));
        return JsonResultGenerator.genSuccessResult(list);
    }

    /**
     * 公司端:根据车牌号模糊查询车辆
     * @author JMR
     * @param companyId 公司id
     * @param carNum 车牌号
     * @return 模糊查询出的车辆
     */
    @GetMapping("companyCarNum/{companyId}&{carNum}")
    public JsonResult companyCarNum(@PathVariable String companyId,@PathVariable String carNum){
        List<CarInfo> carInfos = carInfoService.companyCarNum(companyId,carNum);
        return JsonResultGenerator.genSuccessResult(carInfos);
    }

    /**
     * 公司端:根据车辆品牌模糊搜索车辆
     * @param companyId 公司id
     * @param carBrand 车辆品牌
     * @return 根据条件模糊查询出的车辆
     */
    @GetMapping("companyCarBrand/{companyId}&{carBrand}")
    public JsonResult companyCarBrand(@PathVariable String companyId,@PathVariable String carBrand){
        List<CarInfo> carInfos = carInfoService.companyCarBrand(companyId,carBrand);
        return JsonResultGenerator.genSuccessResult(carInfos);
    }

    /**
     * 公司端:根据车型模糊搜索
     * @param companyId 公司id
     * @param carType 车型
     * @return 根据条件模糊查询出的车辆
     */
    @GetMapping("companyCarType/{companyId}&{carType}")
    public JsonResult companyCarType(@PathVariable String companyId,@PathVariable String carType){
        List<CarInfo> companyCarType = carInfoService.companyCarType(companyId,carType);
        return JsonResultGenerator.genSuccessResult(companyCarType);
    }

    /**
     * 公司端:根据车的使用年限查询
     * @param companyId 公司id
     * @param carYear 车是用年限
     * @return 根据条件查询出车辆
     */
    @GetMapping("companyCarYear/{companyId}&{carYear}")
    public JsonResult companyCarYear(@PathVariable String companyId,
                                     @PathVariable Integer carYear){
        List<CarInfo> companyCarYear = carInfoService.companyCarYear(companyId,carYear);
        return JsonResultGenerator.genSuccessResult(companyCarYear);
    }

    /**
     * 公司端:根据车辆的状态检索该公司的车辆
     * @param companyId 公司id
     * @param status 状态码
     * @return 返回该公司的该状态下的车
     */
    @GetMapping("/companyCarStatus/{companyId}&{status}")
    public JsonResult companyCarStatus(@PathVariable String companyId,@PathVariable Integer status){
        List<CarInfo> carInfos = carInfoService.companyCarStatus(companyId,status);
        return JsonResultGenerator.genSuccessResult(carInfos);
    }

    /**
     * 默认：短租查询所有车辆
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CarInfo> list = carInfoService.queryAllCar();
        list= generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 默认:添加车辆基本信息
     * @param carInfo 车辆基本信息
     * @return 返回JsonResult
     */
    @PostMapping
    public JsonResult add(@RequestBody CarInfo carInfo) {
        int result = carInfoService.addCarInfo(carInfo);
        return JsonResultGenerator.genSuccessResult(result);
    }

    /**
     * 默认:删除车辆
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable String id) {
        carInfoService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    /**
     * 默认:更新车辆信息
     * @param carInfo 车辆信息
     * @return 返回JsonResult
     */
    @PutMapping
    public JsonResult update(@RequestBody CarInfo carInfo) {
        int result = carInfoService.updateCarInfo(carInfo);
        return JsonResultGenerator.genSuccessResult(result);
    }

    /**
     * 根据id查询车辆信息
     * @param id 车辆id
     * @return 返回JsonResult
     */
    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable String id) {
        CarInfo carInfo = carInfoService.findCarById(id);
        return JsonResultGenerator.genSuccessResult(carInfo);
    }

    /**
     * 删除车辆 (修改车辆status)
     * @param carId 车辆id
     * @return  删除结果
     */
    @GetMapping("/delete/{carId}")
    public JsonResult deleteCar(@PathVariable("carId") String carId){
        return  carInfoService.deleteCar(carId);
    }

    /**
     * 热门车辆推荐
     * @return 返回租用次数最多的车的集合
     */
    @GetMapping("/hotCar")
    public JsonResult queryHotCar(){
        List<CarInfo> carInfoList = carInfoService.queryHotCar();
        return JsonResultGenerator.genSuccessResult(carInfoList);
    }

    /**
     * 查询车辆的详细信息
     * @return 返回车辆的详细信息
     */
    @GetMapping("/detailsCar")
    public JsonResult detailsCar(){
        List<CarInfo> carInfoList = carInfoService.detailsCar();
        return JsonResultGenerator.genSuccessResult(carInfoList);
    }

    /**
     * 车辆的评价信息
     * @param carId 车辆id
     * @return 返回该车辆的评价详情
     */
    @PostMapping("/judge")
    public JsonResult judge(@RequestParam(defaultValue = "0") Integer page,
                            @RequestParam(defaultValue = "0") Integer size,
                            @RequestParam(defaultValue = "0") String carId){
        PageHelper.startPage(page,size);
        List<GeneralJudgeInfo>  generalJudgeInfo = carInfoService.judge(carId);
        PageInfo pageInfo = new PageInfo(generalJudgeInfo);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 查询公司所有车辆
     * @param companyId
     * @return
     */
    @GetMapping("/companyAllCar/{companyId}")
    public JsonResult companyAllCar(@PathVariable String companyId){
        List<CarInfo> companyCarInfoList = carInfoService.companyAllCar(companyId);
        return JsonResultGenerator.genSuccessResult(companyCarInfoList);
    }

    /**
     * 短租排序查询
     * @param page
     * @param size
     * @param flag 1:升序 el:降序
     * @return
     */
    @GetMapping("/shortRent/sort")
    public JsonResult shortRentSort(@RequestParam(defaultValue = "0") Integer page,
                                    @RequestParam(defaultValue = "0") Integer size,
                                    @RequestParam(defaultValue = "1") Integer flag
    ){
        Page pages= PageHelper.startPage(page,size);
        List<CarInfo> list = carInfoService.shortRentSort(flag);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 长租排序查询
     * @param page
     * @param size
     * @param flag 1:升序 el:降序
     * @return
     */
    @GetMapping("/longRent/sort")
    public JsonResult longRentSort(@RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "0") Integer size,
                                   @RequestParam(defaultValue = "1") Integer flag){
        Page pages=PageHelper.startPage(page,size);
        List<CarInfo> list = carInfoService.longRentSort(flag);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     * 周租套餐
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/week")
    public JsonResult weekRent(@RequestParam(defaultValue = "0") Integer page,
                               @RequestParam(defaultValue = "0") Integer size,
                               @RequestParam(defaultValue = "1.0f") Float persent) {
        Page pages= PageHelper.startPage(page, size);
        List<CarInfo> list = carInfoService.carPersent(persent);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 周租排序套餐
     * @param page
     * @param size
     * @param persent
     * @param flag
     * @return
     */
    @GetMapping("/week/sort")
    public JsonResult weekRentSort(@RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "0") Integer size,
                                   @RequestParam(defaultValue = "1.0f") Float persent,
                                   @RequestParam(defaultValue = "1") Integer flag) {
        System.out.println(page+","+size+","+persent+","+flag+"");
        Page pages=PageHelper.startPage(page, size);
        List<CarInfo> list = carInfoService.carPersent(persent,flag);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 月租套餐
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/month")
    public JsonResult month(@RequestParam(defaultValue = "0") Integer page,
                            @RequestParam(defaultValue = "0") Integer size,
                            @RequestParam(defaultValue = "1.0f") Float persent) {
        Page pages= PageHelper.startPage(page, size);
        List<CarInfo> list = carInfoService.carPersent(persent);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 月租排序套餐
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/month/sort")
    public JsonResult monthRentSort(@RequestParam(defaultValue = "0") Integer page,
                                    @RequestParam(defaultValue = "0") Integer size,
                                    @RequestParam(defaultValue = "1.0f") Float persent,
                                    @RequestParam(defaultValue = "1") Integer flag
    ) {
        Page pages=PageHelper.startPage(page, size);
        List<CarInfo> list = carInfoService.carPersent(persent,flag);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("averageJudge/{carId}")
    public JsonResult averageJudge(@PathVariable String carId){
        Float averageJudge = carInfoService.averageJudge(carId);
        return JsonResultGenerator.genSuccessResult(averageJudge);
    }

    /**
     * 模糊查询车辆信息
     * @param page
     * @param size
     * @param searchWords
     * @return
     */
    @GetMapping("searchCars")
    public JsonResult searchCars(@RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "0") Integer size,
                                 @RequestParam(defaultValue = "") String searchWords) {
        Page pages= PageHelper.startPage(page, size);
        List<CarInfo> list = carInfoService.searchAllCars(searchWords);
        list= generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("searchCarsMutil")
    public JsonResult searchCarsMutil(@RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "0") Integer size,
                                      @RequestParam(defaultValue = "") String carType,
                                      @RequestParam(defaultValue = "") String carBrand,
                                      @RequestParam(defaultValue = "") String carPriceBegin,
                                      @RequestParam(defaultValue = "") String carPriceEnd,
                                      @RequestParam(defaultValue = "") String carSeatBegin,
                                      @RequestParam(defaultValue = "") String carSeatEnd,
                                      @RequestParam(defaultValue = "") String companyId){

        // 根据车辆品牌名字查询品牌Id
        List<String> carBradIds= carBrandService.carBrandIds(carBrand);
        Page pages= PageHelper.startPage(page, size);
        List<CarInfo> list= carInfoService.searchAllCarsMutil(carType,carBradIds,
                carPriceBegin,carPriceEnd,carSeatBegin,carSeatEnd,companyId);
        list= generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);

    }







    /**
     * 查看公司车辆信息
     * @param companyId 公司id
     * @return 返回该公司车辆的详情
     */
    @GetMapping("/companyAllCar")
    public JsonResult companyAllCarByPage(@RequestParam(defaultValue = "0") Integer page,
                                          @RequestParam(defaultValue = "0") Integer size,
                                          @RequestParam(defaultValue = "0") String companyId){
        Page pages = PageHelper.startPage(page,size);
        List<CarInfo>  companyCarInfoList = carInfoService.companyAllCar(companyId);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 查看公司车辆周租月租长租信息
     * @param companyId 公司id
     * @return 返回该公司车辆的详情
     */
    @GetMapping("/companyAllDiacountCar")
    public JsonResult companyAllDiscountCarByPage(@RequestParam(defaultValue = "") Integer page,
                                                  @RequestParam(defaultValue = "") Integer size,
                                                  @RequestParam(defaultValue = "") Float persent,
                                                  @RequestParam(defaultValue = "") String companyId){
        Page pages=PageHelper.startPage(page,size);
        List<CarInfo>  companyCarInfoList = carInfoService.companyAllCarPersent(persent,companyId);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }



    /**
     * 公司车辆短租排序查询
     * @param page
     * @param size
     * @param flag 1:升序 el:降序
     * @return
     */
    @GetMapping("/shortCompanyCarRent/sort")
    public JsonResult shortRentSort(@RequestParam(defaultValue = "") Integer page,
                                    @RequestParam(defaultValue = "") Integer size,
                                    @RequestParam(defaultValue = "") Integer flag,
                                    @RequestParam(defaultValue = "") String companyId
    ){
        Page pages= PageHelper.startPage(page,size);
        List<CarInfo> list = carInfoService.shortCompanyCarRentSort(companyId,flag);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 公司车辆长租排序查询
     * @param page
     * @param size
     * @param flag 1:升序 el:降序
     * @return
     */
    @GetMapping("/longCompanyCarRent/sort")
    public JsonResult longRentSort(@RequestParam(defaultValue = "") Integer page,
                                   @RequestParam(defaultValue = "") Integer size,
                                   @RequestParam(defaultValue = "") Integer flag,
                                   @RequestParam(defaultValue = "") String companyId){
        Page pages=PageHelper.startPage(page,size);
        List<CarInfo> list = carInfoService.longCompanyCarRentSort(companyId,flag);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(pages);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 公司车辆周租套餐
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/companyCarWeek")
    public JsonResult weekCompanyCarRent(@RequestParam(defaultValue = "") Integer page,
                                         @RequestParam(defaultValue = "") Integer size,
                                         @RequestParam(defaultValue = "") Float persent,
                                         @RequestParam(defaultValue = "") Integer flag,
                                         @RequestParam(defaultValue = "") String companyId
    ){
        Page pages= PageHelper.startPage(page,size);
        List<CarInfo> list = carInfoService.companyCarPersent(persent,flag,companyId);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     * 公司车辆月租套餐
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/companyCarMonth")
    public JsonResult monthCompanyCarRent(@RequestParam(defaultValue = "") Integer page,
                                          @RequestParam(defaultValue = "") Integer size,
                                          @RequestParam(defaultValue = "") Float persent,
                                          @RequestParam(defaultValue = "") Integer flag,
                                          @RequestParam(defaultValue = "") String companyId
    ) {
        Page pages= PageHelper.startPage(page,size);
        List<CarInfo> list = carInfoService.companyCarPersent(persent,flag,companyId);
        list=generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     * 模糊查询公司车辆信息
     * @param page
     * @param size
     * @param searchWords
     * @return
     */
    @GetMapping("/searchAllCompanyCars")
    public JsonResult searchCompanyCars(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "0") Integer size,
                                        @RequestParam(defaultValue = "") String companyId,
                                        @RequestParam(defaultValue = "") String searchWords){
        PageHelper.startPage(page, size);
        System.out.println(companyId);
        System.out.println(searchWords);
        List<CarInfo> list = carInfoService.searchAllCompanyCars(companyId,searchWords);
        System.out.println(list.size());
        List<CarInfo> lists= generalImageService.addCarImage(list);
        PageInfo pageInfo = new PageInfo(lists);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }


}
