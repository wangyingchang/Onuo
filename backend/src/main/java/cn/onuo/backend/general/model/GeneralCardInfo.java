package cn.onuo.backend.general.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "general_card_info")
public class GeneralCardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "card_gender")
    private Byte cardGender;

    @Column(name = "card_address")
    private String cardAddress;

    private Date birthday;

    @Column(name = "address_now")
    private String addressNow;

    @Column(name = "status")
    private Byte status;


}