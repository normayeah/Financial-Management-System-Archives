package com.dao;

import com.entity.DaikuanbanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaikuanbanliVO;
import com.entity.view.DaikuanbanliView;


/**
 * 贷款办理
 *
 */
public interface DaikuanbanliDao extends BaseMapper<DaikuanbanliEntity> {
	
	List<DaikuanbanliVO> selectListVO(@Param("ew") Wrapper<DaikuanbanliEntity> wrapper);
	
	DaikuanbanliVO selectVO(@Param("ew") Wrapper<DaikuanbanliEntity> wrapper);
	
	List<DaikuanbanliView> selectListView(@Param("ew") Wrapper<DaikuanbanliEntity> wrapper);

	List<DaikuanbanliView> selectListView(Pagination page,@Param("ew") Wrapper<DaikuanbanliEntity> wrapper);
	
	DaikuanbanliView selectView(@Param("ew") Wrapper<DaikuanbanliEntity> wrapper);
}
