package cn.onuo.backend.common.mapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author edward on 2018/5/11.
 */
public interface MyMapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
