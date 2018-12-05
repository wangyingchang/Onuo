package cn.onuo.backend.general.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.company.model.CompanyInfo;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import cn.onuo.backend.general.service.GeneralJudgeInfoService;
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
@RequestMapping("/general/judge/info")
public class GeneralJudgeInfoController {
    @Resource
    private GeneralJudgeInfoService generalJudgeInfoService;

    @PostMapping
    public JsonResult add(@RequestBody GeneralJudgeInfo generalJudgeInfo) {
        generalJudgeInfoService.save(generalJudgeInfo);
        return JsonResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") String id) {
        generalJudgeInfoService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody GeneralJudgeInfo generalJudgeInfo) {
        generalJudgeInfoService.update(generalJudgeInfo);
        return JsonResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable("id") String id) {
        GeneralJudgeInfo generalJudgeInfo = generalJudgeInfoService.findById(id);
        return JsonResultGenerator.genSuccessResult(generalJudgeInfo);
    }

    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralJudgeInfo> list = generalJudgeInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 用户对订单进行评价
     * @param cardId 用户的身份证id
     * @return 若能根据id查询到订单, 则用户可以对订单进行评价, 反正返回没有订单不能进行评价
     */

    @PostMapping("/judgeOrderByCardId")
    public JsonResult addJudge(String cardId,GeneralJudgeInfo generalJudgeInfo) {
        IdGenerator idGenerator=new IdGenerator();
        generalJudgeInfo.setJudgeId(idGenerator.toString());
        return  generalJudgeInfoService.saveJudgeInfo(cardId,generalJudgeInfo);
    }


    /**
     * 用户对车辆或者公司进行星级评价
     * @param cardId 用户身份证id
     * @return 若能根据id查到用户订单信息,则能进行评价;反之,返回错误信息
     */
    @PostMapping("/judgeOrderStart")
    public JsonResult addStartJudge(String cardId,GeneralJudgeInfo generalJudgeInfo){
        IdGenerator idGenerator=new IdGenerator();
        generalJudgeInfo.setJudgeId(idGenerator.toString());
        return generalJudgeInfoService.saveJudgeScore(cardId,generalJudgeInfo);
    }

    /**
     * 分页查询车辆,或者公司的所有文字评价
     * @param page 页数
     * @param size 每页的个数
     * @return 返回评价信息列表
     */
    @GetMapping("/carOrCompanyId/{carOrCompanyId}")
    public JsonResult listCount(@RequestParam(defaultValue = "0") Integer page,
                                @RequestParam(defaultValue = "0") Integer size,
                                @PathVariable("carOrCompanyId")String carOrCompanyId) {
        PageHelper.startPage(page,size);
        List<GeneralJudgeInfo> list = generalJudgeInfoService.getDetailedAssessmentByCarIdOrCompanyId(carOrCompanyId);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 查询公司所有评价信息(分页)
     * @param page
     * @param size
     * @param id 公司Id
     * @return
     */
    @GetMapping("/id")
    public JsonResult queryCompanyJudgeByCompanyId(@RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "0") Integer size,
                                                   @RequestParam(defaultValue = "0") String id){
        PageHelper.startPage(page,size);
        List<CompanyInfo> list = generalJudgeInfoService.queryCompanyJudgeByCompanyId(id);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 查询对车辆的所有评价
     * @param page
     * @param size
     * @param carId 车辆id
     * @return
     */
    @GetMapping("/carId")
    public JsonResult queryCarJudgeByCarId(@RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "0") Integer size,
                                               @RequestParam(defaultValue = "0") String carId){
        PageHelper.startPage(page,size);
        List<CompanyInfo> list = generalJudgeInfoService.queryCarJudgeByCarId(carId);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 查询订单评价
     * @param orderId
     * @return
     */
    @GetMapping("/orderId")
    public JsonResult queryOrderJudgeById(@RequestParam String orderId){
        GeneralJudgeInfo generalJudgeInfo=generalJudgeInfoService.queryOrderJudgeById(orderId);
        return JsonResultGenerator.genSuccessResult(generalJudgeInfo);
    }

    /**
     * 添加订单评价
     * @param generalJudgeInfo
     * @return
     */
    @PostMapping("/addJudgeInfo")
    public JsonResult addJudgeInfo(@RequestBody GeneralJudgeInfo generalJudgeInfo) {
        int rows=generalJudgeInfoService.addJudge(generalJudgeInfo);
        return JsonResultGenerator.genSuccessResult(rows);
    }

}
