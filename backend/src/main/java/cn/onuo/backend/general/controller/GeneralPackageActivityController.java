package cn.onuo.backend.general.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.model.GeneralPackageActivity;
import cn.onuo.backend.general.service.GeneralPackageActivityService;
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
@RequestMapping("/general/package/activity")
public class GeneralPackageActivityController {
    @Resource
    private GeneralPackageActivityService generalPackageActivityService;

    @PostMapping
    public JsonResult add(@RequestBody GeneralPackageActivity generalPackageActivity) {
        generalPackageActivityService.save(generalPackageActivity);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        generalPackageActivityService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody GeneralPackageActivity generalPackageActivity) {
        generalPackageActivityService.update(generalPackageActivity);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        GeneralPackageActivity generalPackageActivity = generalPackageActivityService.findById(id);
        return JsonResultGenerator.genSuccessResult(generalPackageActivity);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralPackageActivity> list = generalPackageActivityService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
