package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LicaichanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LicaichanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LicaichanpinView;


/**
 * 理财产品
 *
 */
public interface LicaichanpinService extends IService<LicaichanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LicaichanpinVO> selectListVO(Wrapper<LicaichanpinEntity> wrapper);
   	
   	LicaichanpinVO selectVO(@Param("ew") Wrapper<LicaichanpinEntity> wrapper);
   	
   	List<LicaichanpinView> selectListView(Wrapper<LicaichanpinEntity> wrapper);
   	
   	LicaichanpinView selectView(@Param("ew") Wrapper<LicaichanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LicaichanpinEntity> wrapper);
}

