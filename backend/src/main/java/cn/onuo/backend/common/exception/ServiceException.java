package cn.onuo.backend.common.exception;

/**
 * @author edward on 2018/5/8.
 * <p>
 * <p>
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfigurer
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
