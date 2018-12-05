package cn.onuo.backend.order.model;

import cn.onuo.backend.car.model.CarInfo;
import cn.onuo.backend.general.model.GeneralImage;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author Time
 * @date 2018/10/14
 */
@Table(name = "order_info")
@Data
public class OrderInfo {
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "car_licence_id")
    private String carLicenceId;

    @Column(name = "car_judge_id")
    private String carJudgeId;

    @Column(name = "order_begin_time")
    private Date orderBeginTime;

    @Column(name = "order_end_time")
    private Date orderEndTime;

    @Column(name = "total_money")
    private Float totalMoney;

    @Column(name = "rent_days")
    private Integer rentDays;

    @Column(name = "car_activity_id")
    private String carActivityId;

    @Column(name = "evaluate_info")
    private String evaluateInfo;


    @Transient
    private CarInfo carInfo;

    @Transient
    private GeneralImage generalImage;

}