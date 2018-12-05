package cn.onuo.backend.general.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.model.GeneralNotifyInfo;
import cn.onuo.backend.general.service.GeneralNotifyInfoService;
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
@RequestMapping("/general/notify/info")
public class GeneralNotifyInfoController {
    @Resource
    private GeneralNotifyInfoService generalNotifyInfoService;

    /**
     * 添加通知公告，或者法律法规信息
     * @return 添加结果
     */
    @PostMapping("/addNotify")
    public JsonResult addNotify(@RequestBody GeneralNotifyInfo generalNotifyInfo) {
        IdGenerator idGenerator=new IdGenerator();
        generalNotifyInfo.setNotifyId(idGenerator.toString());
        generalNotifyInfoService.save(generalNotifyInfo);
        return JsonResultGenerator.genSuccessResult("添加成功");
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        generalNotifyInfoService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody GeneralNotifyInfo generalNotifyInfo) {
        generalNotifyInfoService.update(generalNotifyInfo);
        return JsonResultGenerator.genSuccessResult();
    }

    /**
     * 根据notifyId查询公知公告
     * @param notifyId id
     * @return  查询结果
     */
    @GetMapping("/{notifyId}")
    public JsonResult notifyInfoDetail(@PathVariable("notifyId") String notifyId) {
        GeneralNotifyInfo generalNotifyInfo= generalNotifyInfoService.getNotifyInfoByNotifyId(notifyId);
        return JsonResultGenerator.genSuccessResult(generalNotifyInfo);
    }

    /**
     * 分页查询所有通告
     * @param page 当前页
     * @param size 每页的条数
     * @return 分页数据
     */
    @GetMapping("/all")
    public JsonResult listAll(@RequestParam(defaultValue = "0") Integer page,
                              @RequestParam(defaultValue = "2") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralNotifyInfo> list = generalNotifyInfoService.getAllNotifyInfo();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
}
