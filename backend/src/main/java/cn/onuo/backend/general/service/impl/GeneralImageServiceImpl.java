package cn.onuo.backend.general.service.impl;

import cn.onuo.backend.car.model.CarInfo;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.general.dao.GeneralImageMapper;
import cn.onuo.backend.general.model.GeneralImage;
import cn.onuo.backend.general.service.GeneralImageService;
import cn.onuo.backend.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
@Service
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
public class GeneralImageServiceImpl extends AbstractService<GeneralImage> implements GeneralImageService {
    @Resource
    private GeneralImageMapper generalImageMapper;
    /**
     * 添加图片
     * @author Manba
     * @param generalImage 图片信息
     * @return
     */
    @Override
    public int addImgInfo(GeneralImage generalImage) {
        generalImage.setImgId(IdGenerator.getNewUserId());
        this.save(generalImage);
        return 1;
    }
    /**
     * 更新图片信息
     * @author Manba
     * @param generalImage 图片信息
     * @return
     */
    @Override
    public int updateImgInfo(GeneralImage generalImage) {
        this.update(generalImage);
        return 1;
    }

    @Override
    public List<CarInfo> addCarImage(List<CarInfo> lists){
        for (CarInfo entity : lists){
            Condition imageCondition=new Condition(GeneralImage.class);
            Example.Criteria criterialTmp= imageCondition.createCriteria();
            criterialTmp.andEqualTo("imgAssociationId",entity.getCarId());
            entity.setGeneralImage(this.findByCondition(imageCondition));
            if (entity.getGeneralImage()==null){
                GeneralImage generalImage=new GeneralImage();
                List<GeneralImage> list=new ArrayList<>();
                list.add(generalImage);
                entity.setGeneralImage(list);
            }
        }
        return lists;
    }


}
