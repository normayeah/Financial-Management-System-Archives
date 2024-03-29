package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdaikuanchanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdaikuanchanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdaikuanchanpinView;


/**
 * 贷款产品评论表
 *
 */
public interface DiscussdaikuanchanpinService extends IService<DiscussdaikuanchanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdaikuanchanpinVO> selectListVO(Wrapper<DiscussdaikuanchanpinEntity> wrapper);
   	
   	DiscussdaikuanchanpinVO selectVO(@Param("ew") Wrapper<DiscussdaikuanchanpinEntity> wrapper);
   	
   	List<DiscussdaikuanchanpinView> selectListView(Wrapper<DiscussdaikuanchanpinEntity> wrapper);
   	
   	DiscussdaikuanchanpinView selectView(@Param("ew") Wrapper<DiscussdaikuanchanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdaikuanchanpinEntity> wrapper);
}

