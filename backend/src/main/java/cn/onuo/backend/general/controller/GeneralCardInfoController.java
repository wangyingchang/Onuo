package cn.onuo.backend.general.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.model.GeneralCardInfo;
import cn.onuo.backend.general.service.GeneralCardInfoService;
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
@RequestMapping("/general/card/info")
public class GeneralCardInfoController {
    @Resource
    private GeneralCardInfoService generalCardInfoService;

    /**
     *  根据员工身份证号码查询用户信息
     * @param cardId 身份证号码
     * @return 结果
     */
    @GetMapping("/findById/{cardId}")
    public JsonResult findCardInfoById(@PathVariable("cardId") String cardId) {
        return generalCardInfoService.findCardInfoByCardId(cardId);
    }
    /**
     *  根据员工姓名模糊查询员工信息
     * @param page 当前页数
     * @param size 每页显示的条数
     * @param cardInfo 员工的姓名
     * @return 信息结果集
     */
    @GetMapping("/findByCardInfo")
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size,
                           String cardInfo) {
        PageHelper.startPage(page, size);
        List<GeneralCardInfo> list = generalCardInfoService.findCardInfo(cardInfo);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }
//    /**
//     * 添加员工信息
//     * @param generalCardInfo 要添加的员工信息
//     * @return 添加结果
//     */
//    @PostMapping("/add")
//    public JsonResult add(@RequestBody GeneralCardInfo generalCardInfo) {
//        generalCardInfo.setId(IdGenerator.getNewUserId());
//        return  generalCardInfoService.saveCardInfo(generalCardInfo);
//    }
//    /**
//     * 添加员工信息没有验证
//     * @param generalCardInfo 要添加的员工信息
//     * @return 添加结果
//     */
//    @PostMapping("/addCardInfo")
//    public JsonResult addCardInfo(@RequestBody GeneralCardInfo generalCardInfo) {
//        generalCardInfo.setId(IdGenerator.getNewUserId());
//          generalCardInfoService.save(generalCardInfo);
//        return JsonResultGenerator.genSuccessResult(1);
//    }

    /**
     * 删除员工信息
     * @param cardId 输入用户的身份证号码
     * @return 核验结果
     */
    @GetMapping("/delete/{cardId}")
    public JsonResult deleteCardInfo(@PathVariable("cardId") String cardId) {
        return generalCardInfoService.deleteCardInfo(cardId);
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable("id") String id) {
        GeneralCardInfo generalCardInfo = generalCardInfoService.findById(id);
        return JsonResultGenerator.genSuccessResult(generalCardInfo);
    }
    /**
     * 更新员工信息
     * @param generalCardInfo 员工信息
     * @return 返回JsonResult
     */
    @PutMapping
    public JsonResult update(@RequestBody GeneralCardInfo generalCardInfo) {
      return  generalCardInfoService.updateCardInfo(generalCardInfo);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralCardInfo> list = generalCardInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 对用户输入的身份证信息进行核验
     * @param cardId 用户输入的身份证号码
     * @param name 用户输入的身份证姓名
     * @return 核验结果
     */
    @GetMapping("/validate")
    public JsonResult validateCardInfo(@RequestParam(defaultValue = "") String cardId,
                                       @RequestParam(defaultValue = "") String name) {
        return  generalCardInfoService.validateCardInfo(cardId, name);
    }
    /**
     * 添加用户身份证信息
     * @param generalCardInfo 身份证信息
     * @return
     */
    @PostMapping("/addCardInfo")
    public JsonResult add(@RequestBody GeneralCardInfo generalCardInfo) {
        generalCardInfo.setId(IdGenerator.getNewUserId());
        int result = generalCardInfoService.saveCardInfo(generalCardInfo);
        return JsonResultGenerator.genSuccessResult(result);
    }

}
