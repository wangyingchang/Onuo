package cn.onuo.backend.common.utils.ocr;

import lombok.Data;

@Data
public class Driver {

    private String driveId;

    private String driverName;

    private String driverType;

    private String driverCountry;

    //有效期限
    private String DriverValPeriod;

    private String driverStartTime;

    private String driverEndTime;

    private String driverBirthday;

    private String driverSex;

    private String driverAddress;
}
