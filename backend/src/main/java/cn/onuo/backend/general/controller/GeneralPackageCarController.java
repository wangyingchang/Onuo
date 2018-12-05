package cn.onuo.backend.general.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.model.GeneralPackageCar;
import cn.onuo.backend.general.service.GeneralPackageCarService;
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
@RequestMapping("/general/package/car")
public class GeneralPackageCarController {
    @Resource
    private GeneralPackageCarService generalPackageCarService;

    @PostMapping
    public JsonResult add(@RequestBody GeneralPackageCar generalPackageCar) {
        generalPackageCarService.save(generalPackageCar);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        generalPackageCarService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody GeneralPackageCar generalPackageCar) {
        generalPackageCarService.update(generalPackageCar);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        GeneralPackageCar generalPackageCar = generalPackageCarService.findById(id);
        return JsonResultGenerator.genSuccessResult(generalPackageCar);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralPackageCar> list = generalPackageCarService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
