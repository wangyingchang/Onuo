package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.common.exception.ServiceException;
import cn.onuo.backend.sys.dao.RoleMapper;
import cn.onuo.backend.sys.dao.UserMapper;
import cn.onuo.backend.sys.dao.UserRoleMapper;
import cn.onuo.backend.sys.model.User;
import cn.onuo.backend.sys.model.UserRole;
import cn.onuo.backend.sys.service.UserService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author kaikai
* @date 2018/09/30.
*/
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Override
    public User findUserByUsername(final String username) throws ServiceException {
        final User user = this.userMapper.findUserByUserName(username);
        if (user == null) {
            throw new ServiceException("not found this username");
        }
        UserRole userRole=new UserRole();
        userRole.setUserId(user.getId());
        String []s={roleMapper.selectByPrimaryKey
                (userRoleMapper.selectOne(userRole).getRoleId()).getName()};
        user.setPermissionCodeList(s);
        return user;
    }

    @Override
    public boolean verifyPassword(final String rawPassword, final String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
