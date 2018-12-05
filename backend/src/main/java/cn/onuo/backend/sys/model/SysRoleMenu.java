package cn.onuo.backend.sys.model;

import javax.persistence.*;

@Table(name = "sys_role_menu")
public class SysRoleMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 菜单id
     */
    @Column(name = "nenu_id")
    private String nenuId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取菜单id
     *
     * @return nenu_id - 菜单id
     */
    public String getNenuId() {
        return nenuId;
    }

    /**
     * 设置菜单id
     *
     * @param nenuId 菜单id
     */
    public void setNenuId(String nenuId) {
        this.nenuId = nenuId;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}