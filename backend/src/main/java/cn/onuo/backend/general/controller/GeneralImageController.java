package cn.onuo.backend.general.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.model.GeneralImage;
import cn.onuo.backend.general.service.GeneralImageService;
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
@RequestMapping("/general/image")
public class GeneralImageController {
    @Resource
    private GeneralImageService generalImageService;


    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        generalImageService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    /**
     * 更新图片
     * @author Manba
     * @param generalImage
     * @return
     */
    @PutMapping
    public JsonResult update(@RequestBody GeneralImage generalImage) {
        int result = generalImageService.updateImgInfo(generalImage);
        return JsonResultGenerator.genSuccessResult(result);
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable String id) {
        GeneralImage generalImage = generalImageService.findById(id);
        return JsonResultGenerator.genSuccessResult(generalImage);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralImage> list = generalImageService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
    /**
     * 添加图片
     * @author Manba
     * @param generalImage
     * @return
     */
    @PostMapping
    public JsonResult add(@RequestBody GeneralImage generalImage) {
        int result = generalImageService.addImgInfo(generalImage);
        return JsonResultGenerator.genSuccessResult(result);
    }
}
