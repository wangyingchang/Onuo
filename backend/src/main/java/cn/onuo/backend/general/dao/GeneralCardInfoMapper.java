package cn.onuo.backend.general.dao;

import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.general.model.GeneralCardInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author  kaikai
 */
public interface GeneralCardInfoMapper extends MyMapper<GeneralCardInfo> {
    /**
     *  根据员工身份证号码查询员工信息
     * @param cardId 员工身份证号码
     * @return 身份证信息
     */
    GeneralCardInfo selectCardInfoByCardId(@Param("cardId")String cardId);
    /**
     * 模糊查员工信息
     * @param cardInfo 员工信息
     * @return 信息结果集
     */
    List<GeneralCardInfo> selectCardInfo(@Param("cardInfo") String cardInfo);
}