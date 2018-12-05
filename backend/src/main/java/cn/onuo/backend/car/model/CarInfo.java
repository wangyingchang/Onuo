package cn.onuo.backend.car.model;

import cn.onuo.backend.general.model.GeneralImage;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
/**
 * @author  kaikai
 */
@Data
@Table(name = "car_info")
public class CarInfo {
    @Id
    @Column(name = "car_id")
    private String carId;

    @Column(name = "company_area")
    private String companyArea;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "brand_id")
    private String brandId;

    @Column(name = "car_seat")
    private Integer carSeat;

    @Column(name = "car_year")
    private Integer carYear;

    @Column(name = "car_windon")
    private Integer carWindon;

    @Column(name = "car_power")
    private String carPower;

    @Column(name = "air_bag")
    private Integer airBag;

    @Column(name = "car_price")
    private Double carPrice;

    @Column(name = "car_num")
    private String carNum;

    @Column(name = "car_rent_short")
    private Integer carRentShort;

    @Column(name = "car_rent_long")
    private Integer carRentLong;

    @Column(name = "car_rent_comp")
    private Integer carRentComp;

    @Column(name = "car_transmission")
    private String carTransmission;

    @Column(name = "car_rent_count")
    private Integer carRentCount;

    @Column(name = "car_color")
    private String carColor;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "car_quality")
    private Integer carQuality;

    @Column(name = "car_displacement")
    private Integer carDisplacement;

    @Column(name = "car_gps")
    private Integer carGps;

    private Integer status;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "car_maintain")
    private String carMaintain;

    @Column(name = "insurance_id")
    private String insuranceId;

    @Transient
    private CarBrand carBrand;

    @Transient
    private List<GeneralJudgeInfo> generalJudgeInfo;

    @Transient
    private List<GeneralImage> generalImage;
}