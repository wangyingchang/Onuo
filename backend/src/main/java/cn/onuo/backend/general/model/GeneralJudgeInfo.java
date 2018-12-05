package cn.onuo.backend.general.model;

import cn.onuo.backend.sys.model.User;
import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "general_judge_info")
public class GeneralJudgeInfo {
    @Id
    @Column(name = "judge_id")
    private String judgeId;

    @Column(name = "judge_conent")
    private String judgeConent;

    @Column(name = "judge_score")
    private Float judgeScore;

    @Column(name = "judge_time")
    private Date judgeTime;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "car_or_company_id")
    private String carOrCompanyId;

    @Column(name = "use_id")
    private String useId;

    @Transient
    private User user;
}