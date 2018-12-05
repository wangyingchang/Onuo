package cn.onuo.backend.sys.service;

import cn.onuo.backend.sys.model.SysArea;
import cn.onuo.backend.common.service.Service;

import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
public interface SysAreaService extends Service<SysArea> {
    /**
     * 通过城市查询区域
     * @param city
     * @return
     */
    List<String> queryAreaByCity(String city);
}
