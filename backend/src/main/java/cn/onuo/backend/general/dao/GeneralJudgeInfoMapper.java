package cn.onuo.backend.general.dao;

import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.company.model.CompanyInfo;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ounuo
 */
public interface GeneralJudgeInfoMapper extends MyMapper<GeneralJudgeInfo> {


    /**
     * 查询公司星级评价分
     * @param userId 用户id
     * @return 评价分数
     */
    Float selectJudgeScoreByUserId(String userId);
    /**
     * 查询公司或车辆所有的详细评价
     * @param carOrCompanyId 公司或车辆id
     * @return 评价内容
     */
    List<GeneralJudgeInfo> selectDetailedAssessmentByCarIdOrCompanyId(String carOrCompanyId);

    /**
     * 根据订单id查询评价信息
     * @param orderId 订单id
     * @return 结果集
     */
    List<GeneralJudgeInfo> selectJudgeInfoByOrderId(@Param("orderId") String orderId);

    /**
     * 查询公司或车辆所有评价信息(分页)
     * @param id 公司Id
     * @return
     */
    List<CompanyInfo> queryCompanyJudgeByCompanyId(String id);

    /**
     * 查询车辆所有评价信息(分页)
     * @param id 车辆Id
     * @return
     */
    List<CompanyInfo> queryCarJudgeByCarId(String id);

    /**
     * 查询订单评价
     * @param orderId
     * @return
     */
    GeneralJudgeInfo queryOrderJudgeById(String orderId);

    /**
     * 添加订单评价
     * @param generalJudgeInfo
     * @return
     */
    int addJudge(GeneralJudgeInfo generalJudgeInfo);
}