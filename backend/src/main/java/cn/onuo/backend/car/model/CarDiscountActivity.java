package cn.onuo.backend.car.model;

import cn.onuo.backend.general.model.GeneralImage;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import cn.onuo.backend.general.model.GeneralPackageActivity;
import cn.onuo.backend.general.model.GeneralPackageCar;
import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "car_discount_activity")
public class CarDiscountActivity {
    @Id
    @Column(name = "activity_id")
    private String activityId;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "discount_desc")
    private String discountDesc;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    private Integer price;

    @Column(name = "rent_days")
    private Integer rentDays;


    @Transient
    private CarInfo carInfo;

    @Transient
    private CarBrand carBrand;

    @Transient
    private List<GeneralJudgeInfo> generalJudgeInfo;

    @Transient
    private GeneralPackageActivity generalPackageActivity;

    @Transient
    private GeneralPackageCar generalPackageCar;

    @Transient
    private GeneralImage generalImage;

}