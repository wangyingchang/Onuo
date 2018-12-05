package cn.onuo.backend.general.service;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.company.model.CompanyInfo;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import cn.onuo.backend.common.service.Service;

import java.util.List;

/**
 * 用户评价
 * @author kaikai
 * @date 2018/10/02.
 */
public interface GeneralJudgeInfoService extends Service<GeneralJudgeInfo> {
    /**
     * 获得公司或车辆的文字评价
     * @param carOrCompanyId 公司或车辆id
     * @return 返回文字评价
     */
    List<GeneralJudgeInfo> getDetailedAssessmentByCarIdOrCompanyId(String carOrCompanyId);

    /**
     * 添加公司星级评价
     * @param generalJudgeInfo 评价信息
     * @param cardId 用户身份证号码
     * @return 是否成功
     */
    JsonResult saveJudgeScore(String cardId,GeneralJudgeInfo generalJudgeInfo);

    /**
     * 先根据身份证号码查看该用户是否有该订单,如果有则进行订单评价
     * @param generalJudgeInfo 需要评价的 内容
     * @param cardId 用户身份证id
     * @return 是否成功
     */
    JsonResult saveJudgeInfo( String cardId,GeneralJudgeInfo generalJudgeInfo);

    /**
     * 查询公司或车辆所有评价信息(分页)
     * @param id 公司Id
     * @return
     */
    List<CompanyInfo> queryCompanyJudgeByCompanyId(String id);

    List<CompanyInfo> queryCarJudgeByCarId(String carId);

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
