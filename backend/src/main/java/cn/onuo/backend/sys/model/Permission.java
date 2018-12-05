package cn.onuo.backend.sys.model;

import lombok.Data;

import javax.persistence.*;
/**
 * @author kaikai
 * @date 2018/09/30.
 */
@Data
public class Permission {
    /**
     * 权限Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 权限对应的资源
     */
    private String resource;

    /**
     * 权限的代码/通配符,对应代码中@hasAuthority(xx)
     */
    private String code;

    /**
     * 对应的资源操作
     */
    private String handle;

}