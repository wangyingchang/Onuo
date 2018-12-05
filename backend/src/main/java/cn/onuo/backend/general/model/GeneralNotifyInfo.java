package cn.onuo.backend.general.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "general_notify_info")
public class GeneralNotifyInfo {
    @Id
    @Column(name = "notify_id")
    private String notifyId;

    @Column(name = "notify_countent")
    private String notifyCountent;

    @Column(name = "notify_title")
    private String notifyTitle;

    @Column(name = "notify_status")
    private Byte notifyStatus;

    @Column(name = "create_user_id")
    private String createUserId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "notify_remark")
    private String notifyRemark;

    @Column(name = "del_flag")
    private Byte delFlag;

    @Column(name = "type_id")
    private String typeId;

    @Transient
    private GeneralNotifyType generalNotifyType;

}