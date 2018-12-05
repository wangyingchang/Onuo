package cn.onuo.backend.order.controller;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.order.model.OrderInfo;
import cn.onuo.backend.order.service.OrderInfoService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Time
 * @date 2018/10/14.
 */
@RestController
@RequestMapping("/order/info")
public class OrderInfoController {
    @Resource
    private OrderInfoService orderInfoService;

    /**
     * 添加订单
     * @param orderInfo 订单信息
     * @return String
     */
    @PostMapping("/add")
    public JsonResult addOrderInfo(@RequestBody OrderInfo orderInfo){
        return JsonResultGenerator.genSuccessResult(orderInfoService.addOrderInfo(orderInfo));
    }

    /**
     * 根据用户Id查询订单
     * @param userId 用户Id
     * @return 该用户所有订单详情
     */
    @GetMapping("/userId/{userId}")
    public JsonResult queryOrderByUserId(@PathVariable String userId){
        return JsonResultGenerator.genSuccessResult(orderInfoService.queryOrderByUserId(userId));
    }

    /**
     * 查询某公司所有订单
     * @param companyId 公司Id
     * @return 该公司所有订单信息
     */
    @GetMapping("/companyId/{companyId}")
    public JsonResult queryOrderByCompanyId(@PathVariable String companyId){
        return JsonResultGenerator.genSuccessResult(orderInfoService.queryOrderByCompanyId(companyId));
    }

    /**
     * 订单信息确认
     * @param orderId 订单Id
     * @return 订单信息
     */
    @GetMapping("/orderId/{orderId}")
    public JsonResult confirmOrderInfo(@PathVariable String orderId){
        return JsonResultGenerator.genSuccessResult(orderInfoService.confirmOrderInfo(orderId));
    }

    /**
     * 身份证图片OCR识别
     * @param fileCardFront
     * @return 身份证信息
     */
    @PostMapping("/card")
    public JsonResult getCardInfo(@RequestParam("cardFront") MultipartFile fileCardFront){
        return orderInfoService.getCardInfo(fileCardFront);
    }

    /**
     * 驾驶证图片OCR识别
     * @param fileDriver
     * @return 驾驶证信息
     */
    @PostMapping("/driver")
    public JsonResult getDriverInfo(@RequestParam("driverImg") MultipartFile fileDriver){
        return orderInfoService.getDriverInfo(fileDriver);
    }







    @GetMapping
    public JsonResult list(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OrderInfo> list = orderInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable String id) {
        OrderInfo orderInfo = orderInfoService.findById(id);
        return JsonResultGenerator.genSuccessResult(orderInfo);
    }

    @PostMapping
    public JsonResult add(@RequestBody OrderInfo orderInfo) {
        orderInfoService.save(orderInfo);
        return JsonResultGenerator.genSuccessResult();
    }

    @PutMapping
    public JsonResult update(@RequestBody OrderInfo orderInfo) {
        orderInfoService.update(orderInfo);
        return JsonResultGenerator.genSuccessResult("1");
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable String id) {
        orderInfoService.deleteById(id);
        return JsonResultGenerator.genSuccessResult();
    }

    /**
     * 请求阿里支付的Id
     * @return
     */
    @GetMapping("/getAliPayId")
    public JsonResult getAliPayId(){
        String requestId= orderInfoService.AlipayRequest();
        return JsonResultGenerator.genSuccessResult(requestId);
    }

    /**
     * 多条件查询订单信息
     * @param page 当前页
     * @param size 每页显示数
     * @param userId 用户Id
     * @param status 订单状态
     * @param startTime 订单开始时间
     * @param endTime 订单结束时间
     * @return
     */
    @GetMapping("/myorder")
    public JsonResult queryOrder(@RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "0") Integer size,
                                 @RequestParam(defaultValue = "0") String userId,
                                 @RequestParam String status,
                                 @RequestParam String startTime,
                                 @RequestParam String endTime
    ){
        PageHelper.startPage(page, size);
        List<OrderInfo> list = orderInfoService.queryOrder(userId,status,startTime,endTime);
        PageInfo pageInfo = new PageInfo(list);
        return JsonResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/validateOrderResultInfo")
    public JsonResult validateOrderResultInfo(@RequestParam(defaultValue = "0") String outTradeNo,
                                              @RequestParam(defaultValue = "0") String orderId){
        return orderInfoService.validateOrderResultInfo(outTradeNo,orderId);
    }

    @GetMapping("/queryOrderTime")
    public JsonResult queryOrderTime(@RequestParam(defaultValue = "0") String carId,
                                     @RequestParam(defaultValue = "0") String evaluateInfo) {
        List<OrderInfo> list = orderInfoService.queryOrderTime(carId,evaluateInfo);
        return JsonResultGenerator.genSuccessResult(list);

    }
}
