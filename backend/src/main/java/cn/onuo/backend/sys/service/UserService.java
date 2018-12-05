package cn.onuo.backend.sys.service;

import cn.onuo.backend.sys.model.User;
import cn.onuo.backend.common.service.Service;

/**
* @author kaikai
* @date 2018/09/30.
*/
public interface UserService extends Service<User> {
    User findUserByUsername(String username);
    //List<String> findPermCodeListByUsername(String username);
    boolean verifyPassword(final String rawPassword, final String encodedPassword);
}
