package cn.onuo.backend.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_log")
public class SysLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户id
     */

    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名字
     */
    private String username;

    /**
     * 操作
     */
    private String operation;

    /**
     * 次数
     */
    @Column(name = "operation_num")
    private Integer operationNum;

    /**
     * 访问方法
     */
    private String method;

    /**
     * 参数
     */
    private String params;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名字
     *
     * @return username - 用户名字
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名字
     *
     * @param username 用户名字
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取操作
     *
     * @return operation - 操作
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置操作
     *
     * @param operation 操作
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * 获取次数
     *
     * @return operation_num - 次数
     */
    public Integer getOperationNum() {
        return operationNum;
    }

    /**
     * 设置次数
     *
     * @param operationNum 次数
     */
    public void setOperationNum(Integer operationNum) {
        this.operationNum = operationNum;
    }

    /**
     * 获取访问方法
     *
     * @return method - 访问方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置访问方法
     *
     * @param method 访问方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取参数
     *
     * @return params - 参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置参数
     *
     * @param params 参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取ip地址
     *
     * @return ip - ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip地址
     *
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}