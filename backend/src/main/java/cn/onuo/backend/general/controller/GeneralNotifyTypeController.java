package cn.onuo.backend.general.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.model.GeneralNotifyType;
import cn.onuo.backend.general.service.GeneralNotifyTypeService;
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
@RequestMapping("/general/notify/type")
public class GeneralNotifyTypeController {
    @Resource
    private GeneralNotifyTypeService generalNotifyTypeService;

    /**
     * 添加通知公告类型
     * @param generalNotifyType 公告
     * @return 公告信息
     */
    @PostMapping("/add")
    public JsonResult add(@RequestBody GeneralNotifyType generalNotifyType) {
        IdGenerator idGenerator=new IdGenerator();
        generalNotifyType.setTypeId(idGenerator.toString());
        generalNotifyTypeService.save(generalNotifyType);
        return JsonResultGenerator.genSuccessResult("添加成功");
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        generalNotifyTypeService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody GeneralNotifyType generalNotifyType) {
        generalNotifyTypeService.update(generalNotifyType);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        GeneralNotifyType generalNotifyType = generalNotifyTypeService.findById(id);
        return JsonResultGenerator.genSuccessResult(generalNotifyType);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralNotifyType> list = generalNotifyTypeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
