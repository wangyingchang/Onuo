package cn.onuo.backend.order.dao;

import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.general.model.GeneralCardInfo;
import cn.onuo.backend.order.model.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Time
 * @date 2018/10/14.
 */
public interface OrderInfoMapper extends MyMapper<OrderInfo> {

    /**
     * 添加订单
     * @param orderInfo 订单信息
     * @return
     */
    Boolean addOrderInfo(OrderInfo orderInfo);

    /**
     * 修改车辆状态
     * @param carId 车辆id
     * @param status 状态 0:已出租;1:代表未出租
     */
    void updateCarStatus(@Param("carId") String carId, @Param("status") int status);

    /**
     * 根据用户Id查询订单
     * @param userId 用户Id
     * @return 该用户所有订单详情
     */
    List<OrderInfo> queryOrderByUserId(String userId);

    /**
     * 根据公司Id查询出所有车辆Id
     * @param companyId
     * @return 车辆Id list
     */
    List<String> queryCardIdByCompanyId(String companyId);

    /**
     * 根据车辆Id查询订单
     * @param carIdList 车辆Id list
     * @return
     */
    List<OrderInfo> queryOrderByCarId(List<String> carIdList);


    /**
     * 根据用户身份证id查询订单信息
     * @param cardId 用户身份证id
     * @return 订单信息
     */
    List<OrderInfo> selectOrderInfoByCardId(String cardId);

    /**
     * 根据cardId查询身份证表
     * @param cardId
     * @return
     */
    boolean queryCardByCardId(String cardId);

    /**
     * 更新身份证信息
     * @param generalCardInfo
     * @return
     */
    int updateCardByCardId(GeneralCardInfo generalCardInfo);

    /**
     * 多条件查询订单信息
     * @param userId 用户Id
     * @param status 订单状态
     * @param startTime 订单开始时间
     * @param endTime 订单结束时间
     * @return
     */
    List<OrderInfo> queryOrder(@Param("userId") String userId,
                               @Param("status") String status,
                               @Param("startTime") String startTime,
                               @Param("endTime") String endTime);

    /**
     * 查询车辆订单时间
     * @param carId 车辆id
     * @param evaluateInfo 订单状态
     * @return
     */
    List<OrderInfo> queryOrderTime(@Param("carId") String carId,
                                   @Param("evaluateInfo") String evaluateInfo);
}