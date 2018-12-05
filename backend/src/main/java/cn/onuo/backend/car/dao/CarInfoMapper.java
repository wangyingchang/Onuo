package cn.onuo.backend.car.dao;

import cn.onuo.backend.car.model.CarInfo;
import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarInfoMapper extends MyMapper<CarInfo> {

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
     * @return 车辆信息
     */
    List<CarInfo> queryCarByAll();

    /**
     * 根据车型检索车辆
     * @param carType 车辆类型
     * @return 车辆信息
     */
    List<CarInfo> queryCarByType(String carType);


    /**
     * 根据车购价检索车辆
     * @param startCarPrice 起始价
     * @param endCarPrice 尾价
     * @return 车辆信息
     */
    List<CarInfo> queryCarByPrice(@Param("startCarPrice") double startCarPrice,@Param("endCarPrice") double endCarPrice);


    /**
     * 根据租价检索车辆
     * @param startCarRent 起始租金
     * @param endCarRent 尾租金
     * @return 车辆信息
     */
    List<CarInfo> queryCarByRent(@Param("startRent") int startCarRent,@Param("endRent") int endCarRent);


    /**
     * 根据车辆品牌名检索车辆
     * @param brandName 车辆品牌名
     * @return 车辆信息
     */
    List<CarInfo> queryCarByBrand(String brandName);

    /**
     * 根据车辆座位数检索车辆
     * @param startCarSeat 座位数范围开始
     * @param endCarSeat 座位数范围结束
     * @return 车辆信息
     */
    List<CarInfo> queryCarBySeat(@Param("startCarSeat") int startCarSeat,@Param("endCarSeat") int endCarSeat);

    /**
     * 热门车型推荐
     * @return 返回车辆详细信息结果集
     */
    List<CarInfo> queryHotCar();

    /**
     * 查看车辆详情
     * @return 返回车辆详细信息结果集
     */
    List<CarInfo> detailsCar();

    /**
     * 评价信息查询
     * @param carId 车辆ID
     * @return 返回车辆详细信息结果集
     */
    List<GeneralJudgeInfo> judge(String carId);

    /**
     * 查询公司的所有车辆
     * @param companyId 公司id
     * @return
     */
    List<CarInfo> companyAllCar(String companyId);

    /**
     * 根据车辆状态查询车辆
     * @author JMR
     * @param companyId
     * @param status
     * @return
     */
    List<CarInfo> companyCarStatus(@Param("companyId") String companyId,@Param("status")Integer status);

    /**
     * 根据车牌号模糊搜索车辆
     * @param companyId 公司id
     * @param carNum 车牌号码
     * @return 模糊查询出的该公司的车辆
     */
    List<CarInfo> companyCarNum(@Param("companyId") String companyId,@Param("carNum") String carNum);

    /**
     * 根据车型模糊搜索车辆
     * @param companyId 公司 id
     * @param carBrand 品牌
     * @return 根据条件查出车辆
     */
    List<CarInfo> companyCarBrand(@Param("companyId") String companyId,@Param("carBrand") String carBrand);

    /**
     * 根据车型检索
     * @param companyId 公司id
     * @param carType 车辆类型
     * @return 根据条件查询出车辆
     */
    List<CarInfo> companyCarType(@Param("companyId")String companyId,@Param("carType")String carType);

    /**
     * 根据车辆使用年限检索
     * @param companyId
     * @param carYear
     * @return
     */
    List<CarInfo> companyCarYear(@Param("companyId")String companyId,@Param("carYear")Integer carYear);

    /**
     * 根据id查询车辆信息
     * @param id
     * @return
     */
    CarInfo queryCarInfoById(String id);

    /**
     * 短租升序
     * @return
     */
    List<CarInfo> shortRentSort();

    /**
     * 短租降序
     * @return
     */
    List<CarInfo> shortRentSortDesc();

    /**
     * 长租升序
     * @return
     */
    List<CarInfo> longRentSort();

    /**
     * 长租降序
     * @return
     */
    List<CarInfo> longRentSortDesc();



    List<GeneralJudgeInfo> averageJudge(@Param("carId")String carId);





    /**
     * 公司车辆短租升序
     * @param companyId
     * @return
     */
    List<CarInfo> shortCompanyCarRentSort(String companyId);

    /**
     * 公司车辆短租降序
     * @param companyId
     * @return
     */
    List<CarInfo> shortCompanyCarRentSortDesc(String companyId);

    /**
     * 公司车辆长租升序
     * @param companyId
     * @return
     */
    List<CarInfo> longCompanyCarRentSort(String companyId);

    /**
     * 公司车辆长租降序
     * @param companyId
     * @return
     */
    List<CarInfo> longCompanyCarRentSortDesc(String companyId);
}