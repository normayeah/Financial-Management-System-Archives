package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaikuanbanliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaikuanbanliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaikuanbanliView;


/**
 * 贷款办理
 *
 */
public interface DaikuanbanliService extends IService<DaikuanbanliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaikuanbanliVO> selectListVO(Wrapper<DaikuanbanliEntity> wrapper);
   	
   	DaikuanbanliVO selectVO(@Param("ew") Wrapper<DaikuanbanliEntity> wrapper);
   	
   	List<DaikuanbanliView> selectListView(Wrapper<DaikuanbanliEntity> wrapper);
   	
   	DaikuanbanliView selectView(@Param("ew") Wrapper<DaikuanbanliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaikuanbanliEntity> wrapper);
}

