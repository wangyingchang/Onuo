package cn.onuo.backend.general.service;

import cn.onuo.backend.general.model.GeneralNotifyInfo;
import cn.onuo.backend.common.service.Service;

import java.util.List;

/**
 * @author kaikai
 * @date 2018/10/02.
 */
public interface GeneralNotifyInfoService extends Service<GeneralNotifyInfo> {

    /**
     *  根据notifyId查询公告详细信息
     * @param notifyId 公告id
     * @return 公告信息
     */
    GeneralNotifyInfo getNotifyInfoByNotifyId(String notifyId);

    /**
     *  查询所有通知公告
     * @return 返回公告结果集
     */
    List<GeneralNotifyInfo> getAllNotifyInfo();

}
