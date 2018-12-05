package cn.onuo.backend.general.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author  kaikai
 */
@Data
@Table(name = "general_notify_record")
public class GeneralNotifyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "notify_id")
    private String notifyId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "is_read")
    private Integer isRead;

    @Column(name = "read_date")
    private Date readDate;

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
     * @return notify_id
     */
    public String getNotifyId() {
        return notifyId;
    }

    /**
     * @param notifyId
     */
    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return is_read
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * @param isRead
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * @return read_date
     */
    public Date getReadDate() {
        return readDate;
    }

    /**
     * @param readDate
     */
    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }
}