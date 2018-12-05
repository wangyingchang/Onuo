package cn.onuo.backend.car.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "car_brand")
public class CarBrand {
    @Id
    @Column(name = "brand_id")
    private String brandId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "brand_sort_num")
    private Byte brandSortNum;

    @Column(name = "brand_desc")
    private String brandDesc;

    @Column(name = "first_alphbat")
    private String firstAlphbat;

    /**
     * @return brand_id
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * @param brandId
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    /**
     * @return brand_name
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return brand_sort_num
     */
    public Byte getBrandSortNum() {
        return brandSortNum;
    }

    /**
     * @param brandSortNum
     */
    public void setBrandSortNum(Byte brandSortNum) {
        this.brandSortNum = brandSortNum;
    }

    /**
     * @return brand_desc
     */
    public String getBrandDesc() {
        return brandDesc;
    }

    /**
     * @param brandDesc
     */
    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    /**
     * @return first_alphbat
     */
    public String getFirstAlphbat() {
        return firstAlphbat;
    }

    /**
     * @param firstAlphbat
     */
    public void setFirstAlphbat(String firstAlphbat) {
        this.firstAlphbat = firstAlphbat;
    }
}