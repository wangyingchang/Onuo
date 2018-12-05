package cn.onuo.backend.sys.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.sys.model.UserRole;
import cn.onuo.backend.sys.service.UserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @author kaikai
* @date 2018/09/30.
*/
@RestController
@RequestMapping("/user/role")
public class UserRoleController {
    @Resource
    private UserRoleService userRoleService;

    @PostMapping
    public JsonResult add(@RequestBody UserRole userRole) {
        userRoleService.save(userRole);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        userRoleService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody UserRole userRole) {
        userRoleService.update(userRole);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        UserRole userRole = userRoleService.findById(id);
        return JsonResultGenerator.genSuccessResult(userRole);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserRole> list = userRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
