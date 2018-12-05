package cn.onuo.backend.sys.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.sys.model.RolePermission;
import cn.onuo.backend.sys.service.RolePermissionService;
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
@RequestMapping("/role/permission")
public class RolePermissionController {
    @Resource
    private RolePermissionService rolePermissionService;

    @PostMapping
    public JsonResult add(@RequestBody RolePermission rolePermission) {
        rolePermissionService.save(rolePermission);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        rolePermissionService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody RolePermission rolePermission) {
        rolePermissionService.update(rolePermission);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        RolePermission rolePermission = rolePermissionService.findById(id);
        return JsonResultGenerator.genSuccessResult(rolePermission);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RolePermission> list = rolePermissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
