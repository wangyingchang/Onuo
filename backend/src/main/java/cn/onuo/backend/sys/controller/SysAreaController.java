package cn.onuo.backend.sys.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.sys.model.SysArea;
import cn.onuo.backend.sys.service.SysAreaService;
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
@RequestMapping("/sys/area")
public class SysAreaController {
    @Resource
    private SysAreaService sysAreaService;

    /**
     * 通过城市查询区域
     * @param city
     * @return
     */
    @GetMapping("/getAreaByCity")
    public JsonResult queryAreaByCity(@RequestParam String city){
        return JsonResultGenerator.genSuccessResult(sysAreaService.queryAreaByCity(city));
    }

    @PostMapping
    public JsonResult add(@RequestBody SysArea sysArea) {
        sysAreaService.save(sysArea);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        sysAreaService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody SysArea sysArea) {
        sysAreaService.update(sysArea);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        SysArea sysArea = sysAreaService.findById(id);
        return JsonResultGenerator.genSuccessResult(sysArea);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysArea> list = sysAreaService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
