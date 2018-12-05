package cn.onuo.backend.sys.dao;

import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.sys.model.SysArea;

import java.util.List;

public interface SysAreaMapper extends MyMapper<SysArea> {

    /**
     * 通过城市查询区域
     * @param city
     * @return
     */
    List<String> queryAreaByCity(String city);
}