package cn.onuo.backend.car.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "car_insurance_info")
public class CarInsuranceInfo {
    @Id
    @Column(name = "insurance_id")
    private String insuranceId;

    @Column(name = "insurance_company")
    private String insuranceCompany;

    @Column(name = "insurance_start_time")
    private Date insuranceStartTime;

    @Column(name = "insurance_end_time")
    private Date insuranceEndTime;

    private String phone;

    @Column(name = "insurance_type")
    private String insuranceType;


}