package cn.onuo.backend.company.service;

import cn.onuo.backend.company.model.CompanyInfo;
import cn.onuo.backend.common.service.Service;

import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
public interface CompanyInfoService extends Service<CompanyInfo> {
    /**
     * 根据公司名称模糊查询公司信息
     * @param companyName 公司名称
     * @return 返回公司信息集合
     */
    List<CompanyInfo> findCompanyByName(String companyName);

    /**
     * 根据公司区域id查询公司信息
     * @param areaName 公司区域id
     * @return 返回公司信息集合
     */
    List<CompanyInfo> findCompanyByAreaName(String areaName);

    /**
     * 根据公司名称和城市名 模糊查询并分页
     * @param companyName
     * @param city
     * @return
     */
    List<CompanyInfo> queryCompanyByNameAndCity(String companyName,String city);

    /**
     * 根据公司星级评价查询
     * @param companyGrade 星级评价分
     * @return 返回公司信息集合
     */
    List<CompanyInfo> findCompanyByGrade(Float companyGrade);

    /**
     * 公司禁用，成功返回1 不成功返回0
     * @param id
     * @return 1,0
     */
    int disableCompany(String id);
    /**
     * 根据公司名查询公司信息
     * @param companyName 公司名
     * @return 公司基本信息和评价平均分
     */
    List<CompanyInfo> queryCompanyByName(String companyName);

    /**
     * 查询城市或地区的公司
     * @param city 城市名
     * @return 公司基本信息和评价平均分
     */
    List<CompanyInfo> queryCompanyByCity(String city);

    /**
     * 查询本公司信息
     * @param id 公司id
     * @return 返回公司信息
     */
    CompanyInfo findCompanyById(String id);
    /**
     * 公司注册
     * @param companyInfo 公司对象
     * @return 返回1
     */
    int addCompany(CompanyInfo companyInfo);

    List<CompanyInfo> queryAll();

}
