package cn.onuo.backend.sys.model;

import lombok.Data;

import javax.persistence.*;
/**
 * @author kaikai
 * @date 2018/09/30.
 */
@Data
@Table(name = "user_role")
public class UserRole {
    /**
     * 用户Id
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 角色Id
     */
    @Column(name = "role_id")
    private String roleId;


}