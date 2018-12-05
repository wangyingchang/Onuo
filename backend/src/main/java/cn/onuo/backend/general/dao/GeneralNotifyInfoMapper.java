package cn.onuo.backend.general.dao;

import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.general.model.GeneralNotifyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kaikai
 */
public interface GeneralNotifyInfoMapper extends MyMapper<GeneralNotifyInfo> {
    /**
     * 根据id查询通知详细信息
     * @param notifyId id
     * @return 信息集合
     */
    GeneralNotifyInfo selectNotifyInfoByNotifyId(@Param("notifyId") String notifyId);

    /**
     * 查询所有通知详细信息
     * @return 信息集合
     */
    List<GeneralNotifyInfo> selectAllNotifyInfo();

}