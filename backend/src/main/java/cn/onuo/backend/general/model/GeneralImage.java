package cn.onuo.backend.general.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "general_image")
public class GeneralImage {
    @Id
    @Column(name = "img_id")
    private String imgId;

    @Column(name = "img_path")
    private String imgPath;

    @Column(name = "img_association_id")
    private String imgAssociationId;

    @Column(name = "img_type")
    private String imgType;

    @Column(name = "img_status")
    private Byte imgStatus;

    @Column(name = "img_create_time")
    private Date imgCreateTime;

    @Column(name = "img_update_time")
    private Date imgUpdateTime;

    @Column(name = "img_sort_num")
    private Integer imgSortNum;

}