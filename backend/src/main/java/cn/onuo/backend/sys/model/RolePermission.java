package cn.onuo.backend.sys.model;

import lombok.Data;

import javax.persistence.*;
/**
 * @author kaikai
 * @date 2018/09/30.
 */
@Data
@Table(name = "role_permission")
public class RolePermission {
    /**
     * 角色Id
     */
    @Id
    @Column(name = "role_id")
    private String roleId;

    /**
     * 权限Id
     */
    @Column(name = "permission_id")
    private String permissionId;


}