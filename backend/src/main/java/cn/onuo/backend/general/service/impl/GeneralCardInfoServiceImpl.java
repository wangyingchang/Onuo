package cn.onuo.backend.general.service.impl;

import cn.onuo.backend.common.entity.HttpResult;
import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.service.HttpApiService;
import cn.onuo.backend.common.utils.JsonResultGenerator;
import cn.onuo.backend.general.dao.GeneralCardInfoMapper;
import cn.onuo.backend.general.model.GeneralCardInfo;
import cn.onuo.backend.general.service.GeneralCardInfoService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author kaikai
 * @date 2018/10/02.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class GeneralCardInfoServiceImpl extends AbstractService<GeneralCardInfo> implements GeneralCardInfoService {
    @Resource
    private GeneralCardInfoMapper generalCardInfoMapper;
    @Resource
    private HttpApiService httpApiService;


    @Override
    public JsonResult findCardInfoByCardId(String cardId) {
        GeneralCardInfo generalCardInfo=generalCardInfoMapper.selectCardInfoByCardId(cardId);
        if(generalCardInfo!=null){
            return JsonResultGenerator.genSuccessResult(generalCardInfo).setMessage("查询成功");
        }
        return JsonResultGenerator.genFailResult("查无此人");
    }

    @Override
    public List<GeneralCardInfo> findCardInfo(String cardInfo) {
        return  generalCardInfoMapper.selectCardInfo(cardInfo);
    }

    @Override
    public JsonResult validateCardInfo(String cardId, String name) {
        String res="true";
        HashMap<String, Object> map = new HashMap<>();
        map.put("cardNo", cardId);
        map.put("realName", name);
        map.put("appkey", "05086e34c86298a11cf4c3205325f133");
        HttpResult result = new HttpResult();
        try {
            result = httpApiService.doPost("https://way.jd.com/VerifyIdcard/J65", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer reLength = result.getBody().length();
        if(result.getBody().substring(reLength - 7, reLength - 3).equals(res)){
            return JsonResultGenerator.genSuccessResult().setData(1).setMessage("核验成功");
        }
        return JsonResultGenerator.genFailResult("核验失败").setData(0);
    }
    @Override
    public int saveCardInfo(GeneralCardInfo generalCardInfo) {
        Condition condition=new Condition(GeneralCardInfo.class);
        Example.Criteria criteria= condition.createCriteria();
        criteria.andEqualTo("cardId",generalCardInfo.getCardId());
        List<GeneralCardInfo> lists= this.findByCondition(condition);
        if (lists!=null&&lists.size()>0){
           return 1;
        }
        this.save(generalCardInfo);
        return 1;
}
    /**
     * @param cardId 员工身份证号码
     * @return 结果
     */
    @Override
    public JsonResult deleteCardInfo(String cardId) {
        JsonResult jsonResult=null;
        Condition condition = new Condition(GeneralCardInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("cardId", cardId);
        List<GeneralCardInfo> infos = this.findByCondition(condition);
        if (null == infos || infos.size() < 1) {
            jsonResult= JsonResultGenerator.genFailResult("没有该员工,无法删除").setData(0);
        }else {
            for (GeneralCardInfo generalCardInfo : infos) {
                generalCardInfo.setStatus(Byte.parseByte("0"));
                this.update(generalCardInfo);
                jsonResult =JsonResultGenerator.genSuccessResult(1).setMessage("删除成功");
            }
        }
        return jsonResult;
    }

    @Override
    public JsonResult updateCardInfo(GeneralCardInfo generalCardInfo) {
        JsonResult jsonResult=null;
        Condition condition = new Condition(GeneralCardInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("cardId", generalCardInfo.getCardId());
        List<GeneralCardInfo> list = this.findByCondition(condition);
        if (null == list || list.size() < 1) {
            jsonResult= JsonResultGenerator.genFailResult("没有该员工,无法修改").setData(0);
        }else{
                this.update(generalCardInfo);
                jsonResult =JsonResultGenerator.genSuccessResult(1).setMessage("修改成功");
            }
            return jsonResult;
        }
    }
