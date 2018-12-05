package cn.onuo.backend.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu {
    @Id
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 自己关联自己
     */

    @Column(name = "parent_id")
    private String parentId;

    /**
     * 菜单名字
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 菜单权限
     */
    private String permsission;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序号
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modified_time")
    private Date modifiedTime;

    /**
     * @return menu_id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取自己关联自己
     *
     * @return parent_id - 自己关联自己
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置自己关联自己
     *
     * @param parentId 自己关联自己
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取菜单名字
     *
     * @return name - 菜单名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名字
     *
     * @param name 菜单名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单URL
     *
     * @return url - 菜单URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单URL
     *
     * @param url 菜单URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取菜单权限
     *
     * @return permsission - 菜单权限
     */
    public String getPermsission() {
        return permsission;
    }

    /**
     * 设置菜单权限
     *
     * @param permsission 菜单权限
     */
    public void setPermsission(String permsission) {
        this.permsission = permsission;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modified_time - 修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifiedTime 修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}