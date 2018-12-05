package cn.onuo.backend.sys.controller;

import cn.onuo.backend.common.entity.HttpResult;
import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.jwt.JwtUtil;
import cn.onuo.backend.common.service.HttpApiService;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.sys.model.User;
import cn.onuo.backend.sys.service.UserService;
import cn.onuo.backend.sys.service.impl.UserDetailsServiceImpl;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
* @author kaikai
* @date 2018/09/30.
*/
@Api(value = "用户接口")
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Resource
    private HttpApiService httpApiService;
    @Resource
    private UserService userService;
    @Resource
    private UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserController(final JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/test")
    public JsonResult test(){
        HashMap<String,Object> map=new HashMap<>();
        map.put("cardNo","41072719960315411X");
        map.put("realName","白育恺");
        map.put("appkey","bf355c9c2cdcdba8ac8116ae330670e7");

        HttpResult result=new HttpResult();
        try {
            result= httpApiService.doPost("https://way.jd.com/VerifyIdcard/J65",map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultGenerator.genSuccessResult(result);
    }

    @ApiOperation(value = "用户注册")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping
    public JsonResult register(@RequestBody @Valid final User user,
                               final BindingResult bindingResult) {
        // {"username":"123456", "password":"123456", "email": "123456@qq.com"}
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return JsonResultGenerator.genFailResult(msg);
        } else {
            this.userService.save(user);
            return this.getToken(user);
        }
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @ApiOperation(value = "根据Id删除用户")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "Long")
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable final Long id) {
        this.userService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "验证用户密码")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/password")
    public JsonResult validatePassword(@RequestBody final User user) {
        final User oldUser = this.userService.findById(user.getId());
        final boolean isValidate = this.userService.verifyPassword(user.getPassword(), oldUser.getPassword());
        return JsonResultGenerator.genSuccessResult(isValidate);
    }

    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PutMapping
    public JsonResult update(@RequestBody final User user) {
        this.userService.update(user);
        return this.getToken(this.userService.findById(user.getId()));
    }

    @ApiOperation(value = "根据Id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable final Long id) {
        final User user = this.userService.findById(id);
        return JsonResultGenerator.genSuccessResult(user);
    }

    /**
     * AuthenticationPrincipal 注解可以获得当前用户
     */
    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public JsonResult info(@AuthenticationPrincipal final UserDetails userDetails) {
        final User user = userService.findUserByUsername(userDetails.getUsername());
        return JsonResultGenerator.genSuccessResult(user);
    }

    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "页数", dataType = "Integer")
    })
    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") final Integer page,
                           @RequestParam(defaultValue = "0") final Integer size) {
        PageHelper.startPage(page, size);
        final List<User> list = this.userService.findAll();
        //noinspection unchecked
        final PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

//    @ApiOperation(value = "用户登录")
//    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
//    @PostMapping("/login")
//    public JsonResult login(@RequestBody final User user) {
//        // {"username":"admin", "password":"admin123"}
//        // {"email":"admin@qq.com", "password":"admin123"}
//        if (user.getUsername() == null && user.getEmail() == null) {
//            return JsonResultGenerator.genFailResult("username or email empty");
//        }
//        if (user.getPassword() == null) {
//            return JsonResultGenerator.genFailResult("password empty");
//        }
//        // 用户名登录
//        User dbUser = null;
//        if (user.getUsername() != null) {
//            dbUser = this.userService.findBy("username", user.getUsername());
//            if (dbUser == null) {
//                return JsonResultGenerator.genFailResult("username error");
//            }
//        }
//        // 邮箱登录
//        if (user.getEmail() != null) {
//            dbUser = this.userService.findBy("email", user.getEmail());
//            if (dbUser == null) {
//                return JsonResultGenerator.genFailResult("email error");
//            }
//            user.setUsername(dbUser.getUsername());
//        }
//        // 验证密码
//        //noinspection ConstantConditions
//        if (!this.userService.verifyPassword(user.getPassword(), dbUser.getPassword())) {
//            return JsonResultGenerator.genFailResult("password error");
//        }
//        // 更新登录时间
//        //this.userService.updateLoginTime(user.getUsername());
//        return this.getToken(user);
//    }

    @ApiOperation(value = "用户登录")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/token")
    public JsonResult login(@RequestBody final User user) {
        // {"username":"admin", "password":"admin123"}
        // {"email":"admin@qq.com", "password":"admin123"}
        System.out.println(user);
        if (user.getUsername() == null) {
            return JsonResultGenerator.genFailResult("username empty");
        }
        if (user.getPassword() == null) {
            return JsonResultGenerator.genFailResult("password empty");
        }
        // 用户名登录
        User dbUser = null;
        if (user.getUsername() != null) {
            dbUser = this.userService.findBy("username", user.getUsername());
            if (dbUser == null) {
                return JsonResultGenerator.genFailResult("用户名错误！");
            }
        }
        // 验证密码
        //noinspection ConstantConditions
        if (!this.userService.verifyPassword(user.getPassword(), dbUser.getPassword())) {
            return JsonResultGenerator.genFailResult("密码错误！");
        }
        // 更新登录时间
        //this.userService.updateLoginTime(user.getUsername());
        return this.getToken(user);
    }

    @ApiOperation(value = "用户注销")
    @GetMapping("/logout")
    public JsonResult logout(@AuthenticationPrincipal final UserDetails userDetails) {
        this.jwtUtil.invalidRedisStore(userDetails.getUsername());
        return JsonResultGenerator.genSuccessResult();
    }

    /**
     * 获得 token
     */
    private JsonResult getToken(final User user) {
        final String username = user.getUsername();
        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        final String token = this.jwtUtil.sign(username, userDetails.getAuthorities());
        return JsonResultGenerator.genSuccessResult(token);
    }

}
