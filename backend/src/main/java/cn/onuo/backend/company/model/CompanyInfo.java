package cn.onuo.backend.company.model;


import cn.onuo.backend.general.model.GeneralCardInfo;
import cn.onuo.backend.general.model.GeneralImage;
import cn.onuo.backend.general.model.GeneralJudgeInfo;

import cn.onuo.backend.sys.model.SysArea;
import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author Only Manba
 * @date 2018/10/13
 */
@Data
@Table(name = "company_info")
public class CompanyInfo {
    @Id
    @Column(name = "company_id")
    private String companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_address")
    private String companyAddress;

    @Column(name = "company_desc")
    private String companyDesc;

    @Column(name = "company_phone")
    private String companyPhone;

    @Column(name = "company_longitude")
    private String companyLongitude;

    @Column(name = "company_laittude")
    private String companyLaittude;

    @Column(name = "company_grade")
    private Float companyGrade;

    @Column(name = "company_creat_time")
    private Date companyCreatTime;

    @Column(name = "company_update_time")
    private Date companyUpdateTime;

    @Column(name = "company_regist_money")
    private Integer companyRegistMoney;

    @Column(name = "status")
    private Byte status;

    @Column(name = "company_reponsibility_id")
    private String companyReponsibilityId;

    @Column(name = "company_area_id")
    private String companyAreaId;

    @Column(name = "user_id")
    private String userId;

    @Transient
    private GeneralCardInfo companyResponsibleInfo;

    @Transient
    private List<String> imagePathList;

    @Transient
    private List<GeneralJudgeInfo> judgeList;

    @Transient
    private double avgScore;
    @Transient
    private SysArea sysArea;
}