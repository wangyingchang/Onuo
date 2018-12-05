package cn.onuo.backend.general.service;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.general.model.GeneralCardInfo;
import cn.onuo.backend.common.service.Service;

import java.util.List;

/**
 * @author kaikai
 * @date 2018/10/02.
 */
public interface GeneralCardInfoService extends Service<GeneralCardInfo> {


    /**
     *  根据员工身份证号码查询员工信息
     * @param cardId 身份证号码
     * @return 身份证信息
     */
    JsonResult  findCardInfoByCardId(String cardId);
    /**
     * 根据员工姓名模糊查询员工信息
     * @param cardInfo 员工姓名
     * @return 信息结果集
     */
    List<GeneralCardInfo> findCardInfo(String cardInfo);

    /**
     *
     * 对用户输入的身份证和姓名进行核验
     * @param cardId 用户输入的身份证号码
     * @param name 用户输入的姓名
     * @return 核验信息
     */
    JsonResult validateCardInfo(String cardId,String name);
    /**
     * 添加员工信息(需要先对添加的员工身份证进行核验)
     * @param generalCardInfo 需要填加的员工信息
     * @return 添加结果
     */
    int saveCardInfo(GeneralCardInfo generalCardInfo);

    /**
     * 删除员工信息
     * @param cardId 员工身份证号码
     * @return 结果
     */
    JsonResult deleteCardInfo(String cardId);

    /**
     * 修改员工信息
     * @param generalCardInfo 员工信息
     * @return 修改结果
     */
    JsonResult updateCardInfo(GeneralCardInfo generalCardInfo);

}
