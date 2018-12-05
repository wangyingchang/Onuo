package cn.onuo.backend.sys.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.sys.model.SysLog;
import cn.onuo.backend.sys.service.SysLogService;
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
@RequestMapping("/sys/log")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;

    @PostMapping
    public JsonResult add(@RequestBody SysLog sysLog) {
        sysLogService.save(sysLog);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        sysLogService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody SysLog sysLog) {
        sysLogService.update(sysLog);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        SysLog sysLog = sysLogService.findById(id);
        return JsonResultGenerator.genSuccessResult(sysLog);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysLog> list = sysLogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
