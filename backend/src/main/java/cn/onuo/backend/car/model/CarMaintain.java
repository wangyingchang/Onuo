package cn.onuo.backend.car.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "car_maintain")
public class CarMaintain {
    @Id
    @Column(name = "maintain_id")
    private String maintainId;

    @Column(name = "latest_miantian_time")
    private Date latestMiantianTime;

    @Column(name = "next_maintain_time")
    private Date nextMaintainTime;

    @Column(name = "maintain_desc")
    private String maintainDesc;


}