package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaikuanchanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaikuanchanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaikuanchanpinView;


/**
 * 贷款产品
 *
 */
public interface DaikuanchanpinService extends IService<DaikuanchanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaikuanchanpinVO> selectListVO(Wrapper<DaikuanchanpinEntity> wrapper);
   	
   	DaikuanchanpinVO selectVO(@Param("ew") Wrapper<DaikuanchanpinEntity> wrapper);
   	
   	List<DaikuanchanpinView> selectListView(Wrapper<DaikuanchanpinEntity> wrapper);
   	
   	DaikuanchanpinView selectView(@Param("ew") Wrapper<DaikuanchanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaikuanchanpinEntity> wrapper);
}

