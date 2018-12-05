package cn.onuo.backend.sys.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.sys.model.SysRoleMenu;
import cn.onuo.backend.sys.service.SysRoleMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
@RestController
@RequestMapping("/sys/role/menu")
public class SysRoleMenuController {
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @PostMapping
    public JsonResult add(@RequestBody SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.save(sysRoleMenu);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        sysRoleMenuService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.update(sysRoleMenu);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        SysRoleMenu sysRoleMenu = sysRoleMenuService.findById(id);
        return JsonResultGenerator.genSuccessResult(sysRoleMenu);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRoleMenu> list = sysRoleMenuService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
