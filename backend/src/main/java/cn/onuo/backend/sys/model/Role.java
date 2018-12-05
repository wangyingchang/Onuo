package cn.onuo.backend.sys.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * @author kaikai
 * @date 2018/09/30.
 */
@Data
public class Role {
    /**
     * 角色Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 角色名称
     */
    @NotEmpty(message = "角色名称不能为空")
    private String name;

    @JSONField(serialize = false)
    @Transient
    private List<Permission> permissionList;
}