package cn.onuo.backend.car.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "car_diver_info")
public class CarDiverInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "diver_id")
    private String diverId;

    @Column(name = "diver_name")
    private String diverName;

    @Column(name = "diver_gender")
    private Byte diverGender;

    @Column(name = "diver_start_time")
    private Date diverStartTime;

    @Column(name = "diver_end_time")
    private Date diverEndTime;

    @Column(name = "diver_country")
    private String diverCountry;

    @Column(name = "diver_address")
    private String diverAddress;

    @Column(name = "diver_birthday")
    private Date diverBirthday;

    @Column(name = "diver_type")
    private String diverType;

    @Column(name = "first_licence_time")
    private Date firstLicenceTime;

}