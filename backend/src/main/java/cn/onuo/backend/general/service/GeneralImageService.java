package cn.onuo.backend.general.service;

import cn.onuo.backend.car.model.CarInfo;
import cn.onuo.backend.common.utils.IdGenerator;
import cn.onuo.backend.general.model.GeneralImage;
import cn.onuo.backend.common.service.Service;

import java.util.List;

/**
* @author kaikai
* @date 2018/10/02.
*/
public interface GeneralImageService extends Service<GeneralImage> {

    /**
     * 更新图片信息
     * @author Manba
     * @param generalImage
     * @return
     */
    int addImgInfo(GeneralImage generalImage);
    /**
     * 更新图片信息
     * @author Manba
     * @param generalImage 图片信息
     * @return
     */
    int updateImgInfo(GeneralImage generalImage);

    /**
     * 给车辆添加图片
     * @param lists
     * @return
     */
    List<CarInfo> addCarImage(List<CarInfo> lists);

}
