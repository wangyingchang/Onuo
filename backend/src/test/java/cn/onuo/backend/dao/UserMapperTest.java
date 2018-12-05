package cn.onuo.backend.dao;

import cn.onuo.backend.sys.dao.UserMapper;
import cn.onuo.backend.sys.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @author edward on 2018/6/1.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan("com.nepu.sys.dao")
@Slf4j
public class  UserMapperTest {

//    @Resource
//    UserMapper userMapper;
//
//    @Test
//    public void testGetUserByUsername() {
////        User user = userMapper.findUserByUserName("admin");
////        System.out.println("user:" + user.toString());
//
//    }

}
