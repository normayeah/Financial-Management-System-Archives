package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslicaichanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslicaichanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslicaichanpinView;


/**
 * 理财产品评论表
 *
 */
public interface DiscusslicaichanpinService extends IService<DiscusslicaichanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslicaichanpinVO> selectListVO(Wrapper<DiscusslicaichanpinEntity> wrapper);
   	
   	DiscusslicaichanpinVO selectVO(@Param("ew") Wrapper<DiscusslicaichanpinEntity> wrapper);
   	
   	List<DiscusslicaichanpinView> selectListView(Wrapper<DiscusslicaichanpinEntity> wrapper);
   	
   	DiscusslicaichanpinView selectView(@Param("ew") Wrapper<DiscusslicaichanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslicaichanpinEntity> wrapper);
}

