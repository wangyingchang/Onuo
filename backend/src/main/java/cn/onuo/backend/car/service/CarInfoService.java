package cn.onuo.backend.car.service;

import cn.onuo.backend.car.model.CarInfo;
import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.service.Service;
import cn.onuo.backend.general.model.GeneralJudgeInfo;

import java.util.List;
import java.util.Map;

/**
 * @author Time
 * @date 2018/10/13
 */
public interface CarInfoService extends Service<CarInfo> {

    /**
     * 查询出所有的车辆类型
     * @return 车辆的所有类型
     */
    List<String> queryCarType();

    /**
     * 查询出所有的车辆品牌
     * @return 车辆的所有品牌
     */
    List<String> queryCarBrand();

    /**
     * 检索所有车辆
     * @return 车辆信息的封装信息
     */
    List<Map<String,String>> queryCarByAll();

    /**
     * 根据车型检索车辆
     * @param carType 车辆类型
     * @return 车辆信息
     */
    List<Map<String,String>> queryCarByType(String carType);

    /**
     * 根据车购价检索车辆
     * @param startCarPrice 起始价
     * @param endCarPrice 尾价
     * @return 车辆信息
     */
    List<Map<String,String>> queryCarByPrice(double startCarPrice,double endCarPrice);

    /**
     * 根据租价检索车辆
     * @param startCarRent 起始租金
     * @param endCarRent 尾租金
     * @return 车辆信息
     */
    List<Map<String,String>>queryCarByRent(int startCarRent,int endCarRent);

    /**
     * 根据车辆品牌名检索车辆
     * @param brandName 车辆品牌名
     * @return 车辆信息
     */
    List<Map<String,String>> queryCarByBrand(String brandName);

    /**
     * 根据车辆座位数检索车辆
     * @param startCarSeat 座位数范围开始
     * @param endCarSeat 座位数范围结束
     * @return 车辆信息
     */
    List<Map<String,String>> queryCarBySeat(int startCarSeat,int endCarSeat);

    /**
     * 修改车辆状态
     * @param carId 公司车辆id
     * @return 结果
     */
    JsonResult deleteCar(String carId);

    /**
     * 热门车型推荐
     * @return 热门车型信息
     */
    List<CarInfo> queryHotCar();

    /**
     * 车辆详情查询
     * @return 车辆的详细信息
     */
    List<CarInfo> detailsCar();

    /**
     * 评价信息查询
     * @param carId 车辆Id
     * @return 评价信息
     */
    List<GeneralJudgeInfo> judge(String carId);

    /**
     * 公司车辆全部查询
     * @param companyId 公司Id
     * @return 公司车辆信息
     */
    List<CarInfo> companyAllCar(String companyId);
    /**
     * 添加车辆基本信息
     * @param carInfo 车辆信息
     * @return 返回1,0
     */
    int addCarInfo(CarInfo carInfo);

    /**
     * 更新车辆信息
     * @param carInfo 车辆信息
     * @return 返回1,0
     */
    int updateCarInfo(CarInfo carInfo);

    /**
     * 根据id查询车辆信息
     * @param id 车辆id
     * @return 返回车辆信息
     */
    CarInfo findCarById(String id);
    /**
     * 根据车辆状态查询车辆
     * @param companyId 公司id
     * @param status 车辆状态
     * @return 该公司该状态的车辆
     */
    List<CarInfo> companyCarStatus(String companyId,Integer status);

    /**
     * 根据车牌号模糊查询
     * @param companyId 公司Id
     * @param carNum 车牌号
     * @return
     */
    List<CarInfo> companyCarNum(String companyId,String carNum);

    /**
     * 根据车辆品牌模糊查询车辆
     * @param companyId 公司id
     * @param carBrand 车辆品牌
     * @return 根据条件查询出的车辆
     */
    List<CarInfo> companyCarBrand(String companyId,String carBrand);

    /**
     * 根据车型模糊搜索
     * @param companyId 公司id
     * @param carType 车辆类型
     * @return 根据条件查询出的车辆
     */
    List<CarInfo> companyCarType(String companyId,String carType);


    /**
     * 根据车辆使用年限检索
     * @param companyId 公司id
     * @param carYear 使用年限
     * @return 根据条件查询
     */
    List<CarInfo> companyCarYear(String companyId,Integer carYear);

    /**
     * 短租排序查询
     * @param flag 1:升序 el:降序
     * @return
     */
    List<CarInfo> shortRentSort(Integer flag);

    /**
     * 长租排序查询
     * @param flag 1:升序 el:降序
     * @return
     */
    List<CarInfo> longRentSort(Integer flag);

    /**
     * 降价百分比
     * @param persent
     * @return
     */
    List<CarInfo> carPersent(Float persent);

    /**
     * 降价百分比并排序
     * @param persent
     * @return
     */
    List<CarInfo> carPersent(Float persent,Integer flag);

    /**
     * 查询评价
     * @param carId 车辆id
     * @return
     */
    Float averageJudge(String carId);

    /**
     * 模糊查询所有车辆
     * @param words
     * @return
     */
    List<CarInfo> searchAllCars(String words);

    /**
     * 多条件查询车辆
     * @param carType
     * @param carBrandIds
     * @param carPriceBegin
     * @param carPriceEnd
     * @param carSeatBegin
     * @param carSeatEnd
     * @param companyId
     * @return
     */
    List<CarInfo> searchAllCarsMutil( String carType,
                                      List<String> carBrandIds,
                                      String carPriceBegin,
                                      String carPriceEnd,
                                      String carSeatBegin,
                                      String carSeatEnd,
                                      String companyId);






    /**
     * 公司短租排序查询
     * @param companyId 公司id
     * @param persent 折扣
     * @return
     */
    List<CarInfo> companyAllCarPersent(Float persent,String companyId);

    /**
     * 公司短租排序查询
     * @param companyId 公司id
     * @param flag 1:升序 el:降序
     * @return
     */
    List<CarInfo> shortCompanyCarRentSort(String companyId,Integer flag);


    /**
     * 公司长租排序查询
     * @param companyId 公司id
     * @param flag 1:升序 el:降序
     * @return
     */
    List<CarInfo> longCompanyCarRentSort(String companyId,Integer flag);


    /**
     * 模糊查询公司车辆
     * @param companyId 公司id
     * @param words
     * @return
     */

    List<CarInfo> searchAllCompanyCars(String companyId,String words);

    /**
     * 降价百分比
     * @param companyId  公司id
     * @param persent 降价比
     * @param  flag 排序标志
     * @return
     */
    List<CarInfo> companyCarPersent(Float persent,Integer flag,String companyId);




    /**
     * 查询出所有状态为1的车辆
     * @return 车辆列表
     */
    List<CarInfo> queryAllCar();
}
