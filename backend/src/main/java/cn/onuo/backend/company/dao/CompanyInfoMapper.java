package cn.onuo.backend.company.dao;

import cn.onuo.backend.common.mapper.MyMapper;
import cn.onuo.backend.company.model.CompanyInfo;
import cn.onuo.backend.general.model.GeneralCardInfo;
import cn.onuo.backend.general.model.GeneralImage;
import cn.onuo.backend.general.model.GeneralJudgeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author  Only Manba
 * @date   2018/10/13
 */

public interface CompanyInfoMapper extends MyMapper<CompanyInfo> {
    /**
     * 查询公司图片
     * @param companyId 公司id
     * @return 返回公司图片信息集合
     */
    List<String> getCompanyImg(String companyId);

    /**
     * 查询公司的评论
     * @param companyId 公司id
     * @return 返回公司评价信息集合
     */
    List<GeneralJudgeInfo> getCompanyJudge(String companyId);

    /**
     * 查询公司法人信息
     * @param companyResponsibleId
     * @return
     */
    GeneralCardInfo getCompanyResponsibleInfo(String companyResponsibleId);


    /**
     * 公司区域检索
     * @param companyAreaId 区域id
     * @return 返回公司信息集合
     */
    List<CompanyInfo> getCompanyByAreaId(String companyAreaId);

    /**
     * 公司名称检索
     * @param companyName 公司名称
     * @return 返回公司信息集合
     */
    List<CompanyInfo> getCompanyByName(String companyName);

    /**
     * 公司星级评价检索
     * @param companyGrade 公司星级评价
     * @return 返回公司信息集合
     */
    List<CompanyInfo> getCompanyByGrade(Float companyGrade);
    /**
     * 根据公司名查询公司信息
     * @param companyName 公司名
     * @return 所有公司信息
     */
    List<CompanyInfo> queryCompanyByName(String companyName);

    /**
     * 根据城市区域Id查询公司信息
     * @param areaId 区域Id
     * @return 公司信息
     */
    List<CompanyInfo> queryCompanyByAreaId(String areaId);

    /**
     * 查询城市或地区的公司
     * @param city 城市名
     * @return
     */
    List<CompanyInfo> queryCompanyByCity(String city);

    /**
     * 根据公司Id查询评价表的评分
     * @param companyId 公司Id
     * @return 所有公司评分
     */
    List<Double> queryJudgeScoreByCompanyId(String companyId);

    /**
     * 通过城市名查询城市区域id
     * @param areaName 区域名
     * @return 城市区域Id
     */
    String queryAreaIdByName(String areaName);

    /**
     * 根据公司Id查询出所有图片路径
     * @param companyId 公司Id
     * @return 所有图片的路径
     */
    List<String> queryImgByCompanyId(String companyId);

    /**
     * 根据公司名称和城市名 模糊查询并分页
     * @param companyName
     * @param city
     * @return
     */
    List<CompanyInfo> queryCompanyByNameAndCity(@Param("companyName") String companyName, @Param("city") String city);

    /**
     * 根据区域名查询公司信息
     * @param areaName
     * @return
     */
    List<CompanyInfo> getCompanyByAreaName(String areaName);
}