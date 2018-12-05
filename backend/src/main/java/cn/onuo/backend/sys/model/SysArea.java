package cn.onuo.backend.sys.model;

import javax.persistence.*;

@Table(name = "sys_area")
public class SysArea {
    @Id
    @Column(name = "area_id")
    private String areaId;

    /**
     * 自关联
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 名字
     */
    private String name;

    /**
     * 排序号
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 是否可用
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    /**
     * @return area_id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取自关联
     *
     * @return parent_id - 自关联
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置自关联
     *
     * @param parentId 自关联
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序号
     *
     * @return order_num - 排序号
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置排序号
     *
     * @param orderNum 排序号
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取是否可用
     *
     * @return del_flag - 是否可用
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * 设置是否可用
     *
     * @param delFlag 是否可用
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}