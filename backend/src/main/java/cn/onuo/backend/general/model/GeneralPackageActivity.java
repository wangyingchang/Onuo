package cn.onuo.backend.general.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "general_package_activity")
public class GeneralPackageActivity {
    @Id
    @Column(name = "package_id")
    private String packageId;

    @Column(name = "package_name")
    private String packageName;

    @Column(name = "package_desc")
    private String packageDesc;

    @Column(name = "package_day")
    private Integer packageDay;

    /**
     * @return package_id
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * @param packageId
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    /**
     * @return package_name
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * @param packageName
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * @return package_desc
     */
    public String getPackageDesc() {
        return packageDesc;
    }

    /**
     * @param packageDesc
     */
    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }

    /**
     * @return package_day
     */
    public Integer getPackageDay() {
        return packageDay;
    }

    /**
     * @param packageDay
     */
    public void setPackageDay(Integer packageDay) {
        this.packageDay = packageDay;
    }
}