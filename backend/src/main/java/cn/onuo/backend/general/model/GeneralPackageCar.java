package cn.onuo.backend.general.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "general_package_car")
public class GeneralPackageCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "package_id")
    private String packageId;

    @Column(name = "package_price")
    private Integer packagePrice;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return car_id
     */
    public String getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(String carId) {
        this.carId = carId;
    }

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
     * @return package_price
     */
    public Integer getPackagePrice() {
        return packagePrice;
    }

    /**
     * @param packagePrice
     */
    public void setPackagePrice(Integer packagePrice) {
        this.packagePrice = packagePrice;
    }
}