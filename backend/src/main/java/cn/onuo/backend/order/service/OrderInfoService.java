package cn.onuo.backend.order.service;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.order.model.OrderInfo;
import cn.onuo.backend.common.service.Service;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Time
 * @date 2018/10/14.
 */
public interface OrderInfoService extends Service<OrderInfo> {


    /**
     * 添加订单信息
     * @param orderInfo 订单信息
     * @return String
     */
    String addOrderInfo(OrderInfo orderInfo);

    /**
     * 根据用户Id查询订单
     * @param userId 用户Id
     * @return 该用户所有订单详情
     */
    List<OrderInfo> queryOrderByUserId(String userId);

    /**
     * 查询某公司所有订单
     * @param companyId 公司Id
     * @return 该公司所有订单信息
     */
    List<OrderInfo> queryOrderByCompanyId(String companyId);

    /**
     * 订单信息确认
     * @param orderId 订单Id
     * @return 订单信息
     */
    OrderInfo confirmOrderInfo(String orderId);

    /**
     * 根据身份证号码查询订单
     * @param cardId 身份证号码
     * @return 订单信息集
     */
    List<OrderInfo> getOrderInfoByCardId(String cardId);

    /**
     * 身份证图片OCR识别
     * @param fileCardFront
     * @return 身份证信息
     */
    JsonResult getCardInfo(MultipartFile fileCardFront);

    /**
     * 驾驶证图片OCR识别
     * @param fileDriver
     * @return 驾驶证信息
     */
    JsonResult getDriverInfo( MultipartFile fileDriver);

    /**
     * 支付宝请求订单Id
     * @return
     */
    String AlipayRequest();



    /**
     * 多条件查询订单信息
     * @param userId 用户Id
     * @param status 订单状态
     * @param startTime 订单开始时间
     * @param endTime 订单结束时间
     * @return
     */
    List<OrderInfo> queryOrder(String userId, String status, String startTime, String endTime);


    /**
     *
     * 对用户支付结果进行判断
     * @param outTradeNo 用户支付后的out_trade_no
     * @param orderId   订单id
     * @return 核验信息
     */
    JsonResult validateOrderResultInfo(String outTradeNo,String orderId);

    /**
     * 查询订单时间
     * @param carId 车辆id
     * @param evaluateInfo 车辆状态
     * @return
     */
    List<OrderInfo> queryOrderTime(String carId,String evaluateInfo);

}
