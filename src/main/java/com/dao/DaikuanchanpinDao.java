package com.dao;

import com.entity.DaikuanchanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaikuanchanpinVO;
import com.entity.view.DaikuanchanpinView;


/**
 * 贷款产品
 *
 */
public interface DaikuanchanpinDao extends BaseMapper<DaikuanchanpinEntity> {
	
	List<DaikuanchanpinVO> selectListVO(@Param("ew") Wrapper<DaikuanchanpinEntity> wrapper);
	
	DaikuanchanpinVO selectVO(@Param("ew") Wrapper<DaikuanchanpinEntity> wrapper);
	
	List<DaikuanchanpinView> selectListView(@Param("ew") Wrapper<DaikuanchanpinEntity> wrapper);

	List<DaikuanchanpinView> selectListView(Pagination page,@Param("ew") Wrapper<DaikuanchanpinEntity> wrapper);
	
	DaikuanchanpinView selectView(@Param("ew") Wrapper<DaikuanchanpinEntity> wrapper);
}
