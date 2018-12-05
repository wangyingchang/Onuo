package cn.onuo.backend.common.utils.ocr;

import lombok.Data;

@Data
public class Card {
    private String cardId;

    private String cardName;

    private String cardFamousFamily;

    private String cardAddress;

    private String cardSex;

    private String carBirthday;

    //签发日期
    private String issueDate;

    //失效日期
    private String expirationDate;

    //签发机关
    private String issueAuthority;
}
