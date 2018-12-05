package cn.onuo.backend.company.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.company.model.CompanyInfo;
import cn.onuo.backend.company.service.CompanyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
@RestController
@RequestMapping("/company/info")
public class CompanyInfoController {
    @Resource
    private CompanyInfoService companyInfoService;

    /**
     * 查询所有公司信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping()
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CompanyInfo> list = companyInfoService.queryAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 查询本公司信息（根据id查询）
     * @param id 公司id
     * @return 返回JsonResult
     */
    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable String id) {
        CompanyInfo companyInfo = companyInfoService.findCompanyById(id);
        return JsonResultGenerator.genSuccessResult(companyInfo);
    }

    /**
     * 根据区域名查询公司
     * @param page 页数
     * @param size 每页个数
     * @param areaName 个数区域id
     * @return 返回JsonResult
     */
    @GetMapping("/area")
    public JsonResult findCompanyByAreaName(@RequestParam(defaultValue = "0") Integer page,
                                            @RequestParam(defaultValue = "0") Integer size,
                                            @RequestParam(defaultValue = "0") String areaName){
        PageHelper.startPage(page,size);
        List<CompanyInfo> list = companyInfoService.findCompanyByAreaName(areaName);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据公司名称 模糊查询并分页
     * @param page 页数
     * @param size 每页个数
     * @param companyName
     * @return 返回JsonResult
     */
    @GetMapping("/name")
    public JsonResult findCompanyByName(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "0") Integer size,
                                        @RequestParam(defaultValue = "0") String companyName) {
        PageHelper.startPage(page,size);
        List<CompanyInfo> list = companyInfoService.findCompanyByName(companyName);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据公司名称和城市名 模糊查询并分页
     * @param page
     * @param size
     * @param companyName 公司名
     * @param city 城市名
     * @return
     */
    @GetMapping("/nameAndCity")
    public JsonResult queryCompanyByNameAndCity(@RequestParam(defaultValue = "0") Integer page,
                                                @RequestParam(defaultValue = "0") Integer size,
                                                @RequestParam String companyName,
                                                @RequestParam String city) {
        PageHelper.startPage(page, size);
        List<CompanyInfo> list = companyInfoService.queryCompanyByNameAndCity(companyName,city);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     *根据公司星级评价查询
     * @param page 页数
     * @param size 每页个数
     * @param companyGrade 公司星级评价分
     * @return 返回JsonResult
     */
    @GetMapping("/grade/{companyGrade}")
    public JsonResult findCompanyByGrade(@RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "0") Integer size,
                                         @PathVariable Float companyGrade) {
        PageHelper.startPage(page,size);
        List<CompanyInfo> list = companyInfoService.findCompanyByGrade(companyGrade);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据公司名查询公司信息
     * @param companyName 公司名
     * @return 公司基本信息和评价平均分
     */
    @GetMapping("/search/{companyName}")
    public JsonResult queryCompanyByName(@PathVariable String companyName){
        return JsonResultGenerator.genSuccessResult(companyInfoService.queryCompanyByName(companyName));
    }


    /**
     * 查询城市或地区的公司
     * @param city 城市名
     * @return 公司基本信息和评价平均分
     */
    @GetMapping("/city")
    public JsonResult queryCompanyByCity(@RequestParam String city){
        return JsonResultGenerator.genSuccessResult(companyInfoService.queryCompanyByCity(city));
    }


    /**
     * 注册公司
     * @param companyInfo 公司信息
     * @return 返回JsonResult
     */
    @PostMapping
    public JsonResult add(@RequestBody CompanyInfo companyInfo) {
        int result = companyInfoService.addCompany(companyInfo);
        return JsonResultGenerator.genSuccessResult(result);
    }

    /**
     * 更新公司信息
     * @param companyInfo 公司对象
     * @return 返回JsonResult
     */
    @PutMapping
    public JsonResult update(@RequestBody CompanyInfo companyInfo) {
        companyInfoService.update(companyInfo);
        return JsonResultGenerator.genSuccessResult(1);
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable String id) {
        int result=companyInfoService.disableCompany(id);
        return JsonResultGenerator.genSuccessResult(result);
    }

}
