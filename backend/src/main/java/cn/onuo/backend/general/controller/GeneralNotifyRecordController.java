package cn.onuo.backend.general.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.model.GeneralNotifyRecord;
import cn.onuo.backend.general.service.GeneralNotifyRecordService;
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
@RequestMapping("/general/notify/record")
public class GeneralNotifyRecordController {
    @Resource
    private GeneralNotifyRecordService generalNotifyRecordService;

    @PostMapping
    public JsonResult add(@RequestBody GeneralNotifyRecord generalNotifyRecord) {
        generalNotifyRecordService.save(generalNotifyRecord);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        generalNotifyRecordService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody GeneralNotifyRecord generalNotifyRecord) {
        generalNotifyRecordService.update(generalNotifyRecord);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Long id) {
        GeneralNotifyRecord generalNotifyRecord = generalNotifyRecordService.findById(id);
        return JsonResultGenerator.genSuccessResult(generalNotifyRecord);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralNotifyRecord> list = generalNotifyRecordService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
