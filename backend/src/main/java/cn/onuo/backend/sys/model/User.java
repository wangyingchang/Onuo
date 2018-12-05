package cn.onuo.backend.sys.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
/**
 * @author kaikai
 * @date 2018/09/30.
 */
@Data
public class User {
    /**
     * 唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String email;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像路径
     */
    private String avatar;

    private String resume;

    @Column(name = "register_time")
    private Date registerTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @JSONField(serialize = false)
    @Transient
    private List<Role> roleList;
    /**
     * 这两个字段用于给vue后台登录判断用
     */
    @Transient
    private  String []permissionCodeList;


}