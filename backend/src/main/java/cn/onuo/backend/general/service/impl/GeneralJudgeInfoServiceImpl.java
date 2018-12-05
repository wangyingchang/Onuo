package cn.onuo.backend.general.service.impl;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.company.model.CompanyInfo;
import cn.onuo.backend.general.dao.GeneralJudgeInfoMapper;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import cn.onuo.backend.general.service.GeneralJudgeInfoService;
import cn.onuo.backend.common.service.AbstractService;
import cn.onuo.backend.order.model.OrderInfo;
import cn.onuo.backend.order.service.OrderInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author kaikai
 * @date 2018/10/02.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class GeneralJudgeInfoServiceImpl extends AbstractService<GeneralJudgeInfo> implements GeneralJudgeInfoService {
    @Resource
    private GeneralJudgeInfoMapper generalJudgeInfoMapper;
    @Resource
    private OrderInfoService orderInfoService;

    @Override
    public List<GeneralJudgeInfo> getDetailedAssessmentByCarIdOrCompanyId(String carOrCompanyId) {
        return generalJudgeInfoMapper.selectDetailedAssessmentByCarIdOrCompanyId(carOrCompanyId);
    }

    /**
     *  用户对订单进行星级评价
     * @param cardId 用户身份证号码
     * @param generalJudgeInfo 评价信息
     * @return 评价结果
     */
    @Override
    public JsonResult saveJudgeScore(String cardId, GeneralJudgeInfo generalJudgeInfo) {
        JsonResult jsonResult=null;
        List<OrderInfo> orderInfoList = orderInfoService.getOrderInfoByCardId(cardId);
        if (orderInfoList.size()==0) {
            jsonResult= JsonResultGenerator.genFailResult("没有订单不能进行星级评价").setData(-1);
        } else {
            for (OrderInfo orderInfo : orderInfoList) {
                if (generalJudgeInfoMapper.selectJudgeInfoByOrderId(orderInfo.getOrderId()).size()!=0) {
                    jsonResult= JsonResultGenerator.genFailResult("该订单已经评价过了哦.").setData(1);
                }else {
                    generalJudgeInfo.setOrderId(orderInfo.getOrderId());
                    generalJudgeInfoMapper.insert(generalJudgeInfo);
                    jsonResult = JsonResultGenerator.genSuccessResult().setData(1);
                    break;
                }
            }
        }
        return jsonResult;
    }

    @Override
    public JsonResult saveJudgeInfo(String cardId, GeneralJudgeInfo generalJudgeInfo) {
        JsonResult jsonResult=null;
        System.out.println(cardId+generalJudgeInfo);
        List<OrderInfo> orderInfoList = orderInfoService.getOrderInfoByCardId(cardId);
        if (orderInfoList.size()==0) {
            jsonResult= JsonResultGenerator.genFailResult("没有订单不能进行评价").setData(-1);
        } else {
            for(OrderInfo orderInfo : orderInfoList) {
                if (generalJudgeInfoMapper.selectJudgeInfoByOrderId(orderInfo.getOrderId()).size()!=0) {
                    jsonResult= JsonResultGenerator.genFailResult("您已经评价过了哦.").setData(0);
                }else {
                    generalJudgeInfo.setOrderId(orderInfo.getOrderId());
                    generalJudgeInfoMapper.insert(generalJudgeInfo);
                    jsonResult = JsonResultGenerator.genSuccessResult().setData(1);
                    break;
                }
            }
        }
        return jsonResult;
    }

    @Override
    public List<CompanyInfo> queryCompanyJudgeByCompanyId(String id) {
        return generalJudgeInfoMapper.queryCompanyJudgeByCompanyId(id);
    }

    @Override
    public List<CompanyInfo> queryCarJudgeByCarId(String id) {
        return generalJudgeInfoMapper.queryCarJudgeByCarId(id);
    }

    @Override
    public GeneralJudgeInfo queryOrderJudgeById(String orderId) {
        return generalJudgeInfoMapper.queryOrderJudgeById(orderId);
    }

    @Override
    public int addJudge(GeneralJudgeInfo generalJudgeInfo) {
        generalJudgeInfo.setJudgeId(IdGenerator.getNewUserId());
        generalJudgeInfo.setJudgeTime(new Date());
        return generalJudgeInfoMapper.addJudge(generalJudgeInfo);
    }
}
