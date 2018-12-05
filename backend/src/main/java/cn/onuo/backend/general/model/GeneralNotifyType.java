package cn.onuo.backend.general.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "general_notify_type")
public class GeneralNotifyType {
    @Id
    @Column(name = "type_id")
    private String typeId;

    @Column(name = "type_name")
    private String typeName;

}