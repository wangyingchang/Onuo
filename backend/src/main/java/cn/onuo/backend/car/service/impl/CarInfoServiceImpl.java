package cn.onuo.backend.car.service.impl;

import cn.onuo.backend.car.dao.CarInfoMapper;
import cn.onuo.backend.car.model.CarInfo;
import cn.onuo.backend.car.service.CarInfoService;
import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.service.AbstractService;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.model.GeneralImage;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;


/**
 * @author Time
 * @date 2018/10/13
 */
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class CarInfoServiceImpl extends AbstractService<CarInfo> implements CarInfoService {
    @Resource
    private CarInfoMapper carInfoMapper;

    @Override
    public List<String> queryCarType() {
        return carInfoMapper.queryCarType();
    }

    @Override
    public List<String> queryCarBrand() {
        return carInfoMapper.queryCarBrand();
    }

    @Override
    public List<Map<String, String>> queryCarByAll() {
        return this.carInfo(carInfoMapper.queryCarByAll());
    }

    @Override
    public List<Map<String, String>> queryCarByType(String carType) {
        return this.carInfo(carInfoMapper.queryCarByType(carType));
    }

    @Override
    public List<Map<String, String>> queryCarByPrice(double startCarPrice, double endCarPrice) {
        return this.carInfo(carInfoMapper.queryCarByPrice(startCarPrice, endCarPrice));
    }

    @Override
    public List<Map<String, String>> queryCarByRent(int startRent, int endRent) {
        return this.carInfo(carInfoMapper.queryCarByRent(startRent, endRent));
    }

    @Override
    public List<Map<String, String>> queryCarByBrand(String brandName) {
        return this.carInfo(carInfoMapper.queryCarByBrand(brandName));
    }

    @Override
    public List<Map<String, String>> queryCarBySeat(int startCarSeat, int endCarSeat) {
        return this.carInfo(carInfoMapper.queryCarBySeat(startCarSeat, endCarSeat));
    }

    /**
     * 封装车辆信息的方法
     */
    public List<Map<String, String>> carInfo(List<CarInfo> carInfoList) {
        //封装返回车辆信息
        List<Map<String, String>> list = new ArrayList<>();
        for (CarInfo carInfo : carInfoList) {
            Map<String, String> map = new HashMap<>();
            // 设置车辆id
            map.put("carId", carInfo.getCarId());
            //设置车辆名
            map.put("carName", carInfo.getCarName());
            //设置车辆租价
            map.put("carRent", carInfo.getCarRentShort().toString());
            // 设置车辆图片路径
            List<GeneralImage> generalImageListcarInfo = carInfo.getGeneralImage();
            for (GeneralImage generalImage : generalImageListcarInfo) {
                //返回第一张图片
                if (generalImage.getImgSortNum() == 1 || generalImage.getImgSortNum().equals("1")) {
                    map.put("carImgPath", generalImage.getImgPath());
                }
            }
            // 设置车辆品牌名
            map.put("carBrandName", carInfo.getCarBrand().getBrandName());
            //设置评价分
            //当前车辆所有评价信息
            List<GeneralJudgeInfo> generalJudgeInfoList = carInfo.getGeneralJudgeInfo();
            double scoreSum = 0;
            for (GeneralJudgeInfo g : generalJudgeInfoList) {
                scoreSum += g.getJudgeScore();
            }
            //评价评价分
            double avgScore = scoreSum / generalJudgeInfoList.size();
            map.put("avgScore", String.valueOf(avgScore));
            list.add(map);
        }
        return list;
    }
    @Override
    public JsonResult deleteCar(String carId) {
        JsonResult jsonResult = null;
        Condition condition = new Condition(CarInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("carId", carId);
        List<CarInfo> infos = this.findByCondition(condition);
        if (null == infos || infos.size() < 1) {
            jsonResult = JsonResultGenerator.genFailResult("没有该车辆,无法删除").setData(0);
        } for (CarInfo CarInfo : infos) {
            CarInfo.setStatus(0);
            this.update(CarInfo);
            jsonResult =JsonResultGenerator.genSuccessResult(1).setMessage("删除成功");
        }
        return jsonResult;
    }
    @Override
    public List<CarInfo> queryHotCar() {
        List<CarInfo> carInfoList=carInfoMapper.queryHotCar();
        return carInfoList;
    }

    @Override
    public List<CarInfo> detailsCar() {
        List<CarInfo> carInfoList=carInfoMapper.detailsCar();
        return carInfoList;
    }

    @Override
    public  List<GeneralJudgeInfo> judge(String carId) {
        List<GeneralJudgeInfo> generalJudgeInfos=carInfoMapper.judge(carId);
        return generalJudgeInfos;
    }

    @Override
    public List<CarInfo> companyAllCar(String companyId) {
        List<CarInfo> carInfos=carInfoMapper.companyAllCar(companyId);
        return carInfos;
    }
    /**
     * 添加车辆基本信息
     * @param carInfo 车辆信息
     * @return 返回1
     */
    @Override
    public int addCarInfo(CarInfo carInfo) {
        carInfo.setCarId(IdGenerator.getNewUserId());
        this.save(carInfo);
        return 1;
    }

    /**
     * 更新车辆信息
     * @param carInfo 车辆信息
     * @return 返回1
     */
    @Override
    public int updateCarInfo(CarInfo carInfo) {
        this.update(carInfo);
        return 1;
    }

    /**
     * 根据id查询车辆信息
     * @param id 车辆id
     * @return 返回车辆信息
     */
    @Override
    public CarInfo findCarById(String id) {
        return carInfoMapper.queryCarInfoById(id);
    }
    /**
     * @author  JMR
     * 根据车辆状态查询车辆
     * @param companyId 公司ID
     * @param status 车辆状态码
     * @return 该公司该状态的车辆
     */
    @Override
    public List<CarInfo> companyCarStatus(String companyId, Integer status) {
        List<CarInfo> carInfos=carInfoMapper.companyCarStatus(companyId,status);
        return carInfos;
    }

    /**
     * 根据车牌号模糊检索
     * @param companyId 公司Id
     * @param carNum 车牌号
     * @return
     */
    @Override
    public List<CarInfo> companyCarNum(String companyId, String carNum) {
        List<CarInfo> carInfos=carInfoMapper.companyCarNum(companyId,carNum);
        return carInfos;
    }

    /**
     * 根据车辆品牌检索
     * @param companyId 公司id
     * @param carBrand 车辆品牌
     * @return
     */
    @Override
    public List<CarInfo> companyCarBrand(String companyId, String carBrand) {
        List<CarInfo> carInfos=carInfoMapper.companyCarBrand(companyId,carBrand);
        return carInfos;
    }

    /**
     * 根据类型检索
     * @param companyId 公司id
     * @param carType 车辆类型
     * @return
     */
    @Override
    public List<CarInfo> companyCarType(String companyId, String carType) {
        List<CarInfo> carInfos = carInfoMapper.companyCarType(companyId,carType);
        return carInfos;
    }

    /**
     * 根据使用年限检索
     * @param companyId 公司id
     * @param carYear 使用年限
     * @return
     */
    @Override
    public List<CarInfo> companyCarYear(String companyId, Integer carYear) {
        List<CarInfo> carInfos = carInfoMapper.companyCarYear(companyId,carYear);
        return carInfos;
    }


    @Override
    public List<CarInfo> shortRentSort(Integer flag) {
        if(flag==1) {
            return carInfoMapper.shortRentSort();
        }else{
            return carInfoMapper.shortRentSortDesc();
        }
    }

    @Override
    public List<CarInfo> longRentSort(Integer flag) {
        if(flag==1) {
            return carInfoMapper.longRentSort();
        }else{
            return carInfoMapper.longRentSortDesc();
        }
    }

    @Override
    public List<CarInfo> carPersent(Float persent) {
        List<CarInfo> entities=new ArrayList<>();
        List<CarInfo> lists=new ArrayList<>();
        lists=this.findAll();
        for(CarInfo entity : lists){
            entity.setCarRentShort((int) (entity.getCarRentShort()*persent));
            entity.setCarWindon(entity.getCarRentShort()-entity.getCarRentLong());
            if (true||entity.getStatus()==1){
                entities.add(entity);
            }
        }
        return entities;
    }

    @Override
    public List<CarInfo> carPersent(Float persent,Integer flag) {
        List<CarInfo> entities=new ArrayList<>();
        List<CarInfo> lists=new ArrayList<>();
        if(flag==1) {
            lists = carInfoMapper.shortRentSort();
        }else{
            lists=carInfoMapper.shortRentSortDesc();
        }
        for(CarInfo entity : lists){
            entity.setCarRentShort((int) (entity.getCarRentShort()*persent));
            entity.setCarWindon(entity.getCarRentShort()-entity.getCarRentLong());
            if (true||entity.getStatus()==1){
                entities.add(entity);
            }
        }
        return entities;
    }

    @Override
    public Float averageJudge(String carId) {
        Float average = 0f;
        List<GeneralJudgeInfo> floats = carInfoMapper.averageJudge(carId);
        for(GeneralJudgeInfo f:floats){
            average+=f.getJudgeScore();
        }
        return average/floats.size();
    }




    @Override
    public List<CarInfo> searchAllCars(String words){
        Condition condition=new Condition(CarInfo.class);
        Example.Criteria criteria1= condition.createCriteria();
        criteria1.andEqualTo("status",1);
        Example.Criteria criteria= condition.createCriteria();
        criteria.orLike("companyArea","%"+words+"%");
        criteria.orLike("carName","%"+words+"%");
        criteria.orLike("carPower","%"+words+"%");
        criteria.orLike("carTransmission","%"+words+"%");
        criteria.orLike("carColor","%"+words+"%");
        criteria.orLike("carType","%"+words+"%");
        condition.and(criteria);
        List<CarInfo> infos= this.findByCondition(condition);
        return infos;
    }

    @Override
    public List<CarInfo> searchAllCarsMutil(String carType, List<String> carBrandIds, String carPriceBegin, String carPriceEnd, String carSeatBegin, String carSeatEnd, String companyId) {
        Condition condition=new Condition(CarInfo.class);
        Example.Criteria criteria= condition.createCriteria();
        // 车型
        if (!"0".equals(carType)){
            String[] carTypes=carType.split(",");
            criteria.andIn("carType", Arrays.asList(carTypes));
        }
        // 车辆Ids
        if (carBrandIds.size()>0){
            criteria.andIn("brandId",carBrandIds);
        }
        // 车辆座位数
        criteria.andBetween("carSeat",Integer.parseInt(carSeatBegin),Integer.parseInt(carSeatEnd));
        // 车辆租用价格
        criteria.andBetween("carRentShort",Integer.parseInt(carPriceBegin),Integer.parseInt(carPriceEnd));
        // 公司Id
        if (!"".equals(companyId)&&!"0".equals(companyId)){
            criteria.andEqualTo("companyId",companyId);
        }
        return this.findByCondition(condition);
    }




    @Override
    public List<CarInfo> companyAllCarPersent(Float persent,String companyId){
        List<CarInfo> entities=new ArrayList<>();
        List<CarInfo> lists = new ArrayList<>();
        lists = this.companyAllCar(companyId);
        for(CarInfo entity : lists){
            entity.setCarRentShort((int)(entity.getCarRentShort()* persent));
            entity.setCarWindon(entity.getCarRentShort()-entity.getCarRentLong());
            if(true||entity.getStatus()==1){
                entities.add(entity);
            }
        }
        return entities;
    }

    @Override
    public List<CarInfo> shortCompanyCarRentSort(String companyId,Integer flag) {
        if(flag==1) {
            return carInfoMapper.shortCompanyCarRentSort(companyId);
        }else{
            return carInfoMapper.shortCompanyCarRentSortDesc(companyId);
        }
    }

    @Override
    public List<CarInfo> longCompanyCarRentSort(String companyId,Integer flag) {
        if(flag==1) {
            return carInfoMapper.shortCompanyCarRentSort(companyId);
        }else{
            return carInfoMapper.shortCompanyCarRentSortDesc(companyId);
        }
    }

    @Override
    public List<CarInfo> companyCarPersent(Float persent,Integer flag,String companyId){
        List<CarInfo> entities=new ArrayList<>();
        List<CarInfo> lists = new ArrayList<>();
        lists = this.companyAllCar(companyId);
        if(flag==1) {
            lists = carInfoMapper.shortCompanyCarRentSort(companyId);
        }else{
            lists=carInfoMapper.shortCompanyCarRentSortDesc(companyId);
        }
        for(CarInfo entity : lists){
            entity.setCarRentShort((int)(entity.getCarRentShort()*persent));
            entity.setCarWindon(entity.getCarRentShort()-entity.getCarRentLong());
            if (true||entity.getStatus()==1){
                entities.add(entity);
            }
        }
        return entities;
    }



    @Override
    public List<CarInfo> searchAllCompanyCars(String companyId,String words){
        Condition condition=new Condition(CarInfo.class);
        Example.Criteria criteria1= condition.createCriteria();
        criteria1.andEqualTo("companyId",companyId)
                .andEqualTo("status",1);

        Example.Criteria criteria = condition.createCriteria();
        criteria.orLike("carType","%"+words+"%");
        criteria.orLike("companyArea","%"+words+"%");
        criteria.orLike("carName","%"+words+"%");
        criteria.orLike("carPower","%"+words+"%");
        criteria.orLike("carTransmission","%"+words+"%");
        criteria.orLike("carColor","%"+words+"%");
        criteria.orLike("carType","%"+words+"%");

        condition.and(criteria);

        List<CarInfo> infos= this.findByCondition(condition);
        System.out.println("service:"+infos.size());
        return infos;
    }



    @Override
    public List<CarInfo> queryAllCar() {
        Condition condition=new Condition(CarInfo.class);
        Example.Criteria criteria1= condition.createCriteria();
        criteria1.andEqualTo("status",1);
        List<CarInfo> infos= this.findByCondition(condition);
        return infos;
    }


}
