package cn.onuo.backend.sys.service.impl;

import cn.onuo.backend.sys.dao.PermissionMapper;
import cn.onuo.backend.sys.dao.UserMapper;
import cn.onuo.backend.sys.model.Permission;
import cn.onuo.backend.sys.model.Role;
import cn.onuo.backend.sys.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@SuppressWarnings("SpringJavaAutowiringInspection")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        User user = userMapper.findUserByUserName(username);
        // 权限
        List<String> permCodeList = new ArrayList<>();
        if (user.getRoleList().toString().contains("ROLE_ADMIN")) {
            permCodeList = permissionMapper.findAllPermCode();
        } else {
            for (Role role : user.getRoleList()) {
                List<Permission> perms = role.getPermissionList();
                for (Permission perm : perms) {
                    if (permCodeList.contains(perm.getCode()) == false) {
                        permCodeList.add(perm.getCode());
                    }
                }
            }
        }
        final List<SimpleGrantedAuthority> authorities =
                permCodeList.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
//        final List<SimpleGrantedAuthority> authorities =
//                this.userService.findPermCodeListByUsername(username).stream()
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
        // 角色
        for (Role role : user.getRoleList()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        log.info(authorities.toString());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }


}