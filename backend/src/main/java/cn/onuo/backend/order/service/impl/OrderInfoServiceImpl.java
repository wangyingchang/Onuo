package cn.onuo.backend.order.service.impl;


import cn.onuo.backend.common.entity.HttpResult;
import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.service.HttpApiService;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.common.utils.OCRUtils;
import cn.onuo.backend.order.dao.OrderInfoMapper;
import cn.onuo.backend.order.model.OrderInfo;
import cn.onuo.backend.order.service.OrderInfoService;
import cn.onuo.backend.common.service.AbstractService;
import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.experimental.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Time
 * @date 2018/10/14.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class OrderInfoServiceImpl extends AbstractService<OrderInfo> implements OrderInfoService {
    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Resource
    private HttpApiService httpApiService;

    @Override
    public String addOrderInfo(OrderInfo orderInfo) {
        //随机生成订单id
        orderInfo.setOrderId(IdGenerator.getNewUserId());
        //订单生成当前时间
        orderInfo.setOrderBeginTime(new Date());
        boolean flag=orderInfoMapper.addOrderInfo(orderInfo);
        if(flag){
            //修改车辆状态
            orderInfoMapper.updateCarStatus(orderInfo.getCarId(),0);
            return orderInfo.getOrderId();
        }else{
            return orderInfo.getOrderId();
        }
    }

    @Override
    public List<OrderInfo> queryOrderByUserId(String userId) {
        return orderInfoMapper.queryOrderByUserId(userId);
    }

    @Override
    public List<OrderInfo> queryOrderByCompanyId(String companyId) {
        //所有订单信息
        List<OrderInfo> orderInfoList=null;
        //查询出公司所有车辆Id
        List<String> carIdList=orderInfoMapper.queryCardIdByCompanyId(companyId);
        //判断公司是否有车
        if(carIdList.size()>0) {
            //根据车辆Id查询所有订单
            orderInfoList = orderInfoMapper.queryOrderByCarId(carIdList);
            return orderInfoList;
        }else{
            return orderInfoList;
        }
    }

    @Override
    public OrderInfo confirmOrderInfo(String orderId) {
        return orderInfoMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<OrderInfo> getOrderInfoByCardId(String cardId) {
        return orderInfoMapper.selectOrderInfoByCardId(cardId);
    }

    @Override
    public JsonResult getCardInfo(MultipartFile fileCardFront) {
        return OCRUtils.getCardInfo(fileCardFront);
    }

    @Override
    public JsonResult getDriverInfo(MultipartFile fileDriver) {
        return OCRUtils.getDriverInfo(fileDriver);
    }

    @Override
    public  String AlipayRequest(){

        String result = "";
        try {
            result =httpApiService.doGet("http://120.79.182.104:8080/Alipay/requestMessage?flag=0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        result=result.replace("ResultInfo ","");
        result=result.split(",")[1];
        result=result.split("=")[1];
        result=result.substring(0,result.length()-1);
        return result;
    }
    @Override
    public List<OrderInfo> queryOrder(String userId, String status, String startTime, String endTime) {
        return orderInfoMapper.queryOrder(userId,status,startTime,endTime);
    }

    @Override
    public JsonResult validateOrderResultInfo(String outTradeNo,String orderId) {
        String url = "";
        try {//http://120.79.182.104:8080/Alipay/requestMessage?flag=0&Id=1541422319857369979
            url = httpApiService.doGet("http://120.79.182.104:8080/Alipay/requestMessage?flag=1&Id="+outTradeNo);
            System.out.println(url.substring(16,17).equals("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (url.substring(16,17).equals("1")) {
            OrderInfo orderInfo = this.findById(orderId);
            orderInfo.setEvaluateInfo("4");
            this.update(orderInfo);
            System.out.println(orderInfo);
            return JsonResultGenerator.genSuccessResult("5");
        } else {
            return JsonResultGenerator.genSuccessResult("6");
        }
    }

    @Override
    public List<OrderInfo> queryOrderTime(String carId, String evaluateInfo) {
        return orderInfoMapper.queryOrderTime(carId,evaluateInfo);
    }



}
