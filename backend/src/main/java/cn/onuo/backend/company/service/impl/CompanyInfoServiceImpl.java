package cn.onuo.backend.company.service.impl;

import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.company.dao.CompanyInfoMapper;
import cn.onuo.backend.company.model.CompanyInfo;
import cn.onuo.backend.company.service.CompanyInfoService;
import cn.onuo.backend.common.service.AbstractService;
import cn.onuo.backend.general.model.GeneralCardInfo;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Only Manba
 * @date 2018/10/02.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class CompanyInfoServiceImpl extends AbstractService<CompanyInfo> implements CompanyInfoService {
    @Resource
    private CompanyInfoMapper companyInfoMapper;

    /**
     * 根据公司名称模糊查询
     * @param companyName 公司名称
     * @return 返回封装的公司信息集合
     */
    @Override
    public List<CompanyInfo> findCompanyByName(String companyName) {
        //1.查询出所有的公司
        List<CompanyInfo> companyInfoList = companyInfoMapper.getCompanyByName(companyName);

        for (CompanyInfo companyInfo : companyInfoList) {
            List<String> imgPathList = companyInfoMapper.getCompanyImg(companyInfo.getCompanyId());
            companyInfo.setImagePathList(imgPathList);
        }
        return companyInfoList;
    }

    /**
     * 根据公司区域名查询
     * @param areaName 公司区域名
     * @return 返回封装的公司信息集合
     */
    @Override
    public List<CompanyInfo> findCompanyByAreaName(String areaName) {
        //1.查询出区域Id
        //String companyAreaId=companyInfoMapper.queryAreaIdByName(areaName);
        //2.根据区域Id查询出公司
        //List<CompanyInfo> companyInfoList=companyInfoMapper.getCompanyByAreaId(companyAreaId);

        List<CompanyInfo> companyInfoList=companyInfoMapper.getCompanyByAreaName(areaName);
        for(CompanyInfo companyInfo:companyInfoList){
            List<String> imgPathList = companyInfoMapper.getCompanyImg(companyInfo.getCompanyId());
            companyInfo.setImagePathList(imgPathList);
        }
        return companyInfoList;
    }

    /**
     * 根据公司名称和城市名 模糊查询并分页
     * @param companyName
     * @param city
     * @return
     */
    @Override
    public List<CompanyInfo> queryCompanyByNameAndCity(String companyName,String city) {
        List<CompanyInfo> companyInfoList=companyInfoMapper.queryCompanyByNameAndCity(companyName,city);
        for(CompanyInfo companyInfo:companyInfoList){
            companyInfo.setImagePathList(companyInfoMapper.getCompanyImg(companyInfo.getCompanyId()));
        }
        return companyInfoList;
    }

    /**
     * 根据星级评价查询
     * @param companyGrade 星级评价分
     * @return 返回封装的公司信息集合
     */
    @Override
    public List<CompanyInfo> findCompanyByGrade(Float companyGrade) {

        // 1.查询出所有的公司
        List<CompanyInfo> companyInfoList = companyInfoMapper.getCompanyByGrade(companyGrade);
        for (CompanyInfo companyInfo : companyInfoList) {
            // 2.查询图片信息
            List<String> imgPathList = companyInfoMapper.getCompanyImg(companyInfo.getCompanyId());
            companyInfo.setImagePathList(imgPathList);
            // 3.查询评论信息
            List<GeneralJudgeInfo> generalJudgeInfoList = companyInfoMapper.getCompanyJudge(companyInfo.getCompanyId());
            float score = 0;
            for (GeneralJudgeInfo generalJudgeInfo : generalJudgeInfoList) {
                score += generalJudgeInfo.getJudgeScore();
            }
            float avgScore = score / generalJudgeInfoList.size();
            companyInfo.setAvgScore(avgScore);
        }

        // 4.返回公司list
        return companyInfoList;
    }
    @Override
    public int disableCompany(String id) {
        // 查询公司信息
        CompanyInfo companyInfo= this.findById(id);

        // 若公司信息为空返回0
        if (null==companyInfo){
            return 0;
        }

        // 更新公司信息
        companyInfo.setStatus(Byte.parseByte("0"));
        this.update(companyInfo);

        // 更新成功，返回1
        return 1;
    }

    @Override
    public List<CompanyInfo> queryCompanyByName(String companyName) {
        return this.setAvgJudgeScore(companyInfoMapper.queryCompanyByName(companyName));
    }

    @Override
    public List<CompanyInfo> queryCompanyByCity(String city) {
        //通过城市名获取所有公司信息
        return this.setAvgJudgeScore(companyInfoMapper.queryCompanyByCity(city));
    }

    /**
     * 循环设置公司平均评价分和图片
     * @param companyInfoList 所有公司
     * @return 所有公司
     */
    public List<CompanyInfo> setAvgJudgeScore(List<CompanyInfo> companyInfoList){
        for(CompanyInfo companyInfo:companyInfoList){
            //设置评价分
            List<Double> judgeScoreList=companyInfoMapper.queryJudgeScoreByCompanyId(companyInfo.getCompanyId());
            double sumScore=0;
            for(Double d:judgeScoreList){
                sumScore+=d;
            }
            double aveScore=sumScore/judgeScoreList.size();
            companyInfo.setAvgScore(aveScore);

            //设置图片路径
            List<String> imgPathList=companyInfoMapper.queryImgByCompanyId(companyInfo.getCompanyId());
            companyInfo.setImagePathList(imgPathList);
        }
        return companyInfoList;
    }
    /**
     * 查询公司信息
     * @param id 公司id
     * @return 返回公司信息
     */
    @Override
    public CompanyInfo findCompanyById(String id){
        CompanyInfo companyInfo = this.findById(id);
        // 1.查询公司图片
        List<String> imgPath = companyInfoMapper.getCompanyImg(companyInfo.getCompanyId());
        companyInfo.setImagePathList(imgPath);

        // 2.查询公司评论信息
        List<GeneralJudgeInfo> judgeInfoList = companyInfoMapper.getCompanyJudge(companyInfo.getCompanyId());
        companyInfo.setJudgeList(judgeInfoList);

        //3.查询公司法人信息
        GeneralCardInfo generalCardInfo=companyInfoMapper.getCompanyResponsibleInfo(companyInfo.getCompanyReponsibilityId());
        companyInfo.setCompanyResponsibleInfo(generalCardInfo);
        // 返回公司信息
        return companyInfo;
    }

    /**
     * 公司注册
     * @param companyInfo 公司对象
     * @return 返回1,0
     */
    @Override
    public int addCompany(CompanyInfo companyInfo) {
        companyInfo.setCompanyId(IdGenerator.getNewUserId());
        this.save(companyInfo);
        return 1;
    }
    /**
     * 查询所有公司
     * @return
     */
    @Override
    public List<CompanyInfo> queryAll() {
        List<CompanyInfo> companyInfoList = companyInfoMapper.selectAll();
        for (CompanyInfo companyInfo : companyInfoList) {
            // 设置图片路径
            companyInfo.setImagePathList(companyInfoMapper.getCompanyImg(companyInfo.getCompanyId()));
        }
        return companyInfoList;
    }


}
