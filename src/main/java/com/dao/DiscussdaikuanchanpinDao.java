package com.dao;

import com.entity.DiscussdaikuanchanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdaikuanchanpinVO;
import com.entity.view.DiscussdaikuanchanpinView;


/**
 * 贷款产品评论表
 *
 */
public interface DiscussdaikuanchanpinDao extends BaseMapper<DiscussdaikuanchanpinEntity> {
	
	List<DiscussdaikuanchanpinVO> selectListVO(@Param("ew") Wrapper<DiscussdaikuanchanpinEntity> wrapper);
	
	DiscussdaikuanchanpinVO selectVO(@Param("ew") Wrapper<DiscussdaikuanchanpinEntity> wrapper);
	
	List<DiscussdaikuanchanpinView> selectListView(@Param("ew") Wrapper<DiscussdaikuanchanpinEntity> wrapper);

	List<DiscussdaikuanchanpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdaikuanchanpinEntity> wrapper);
	
	DiscussdaikuanchanpinView selectView(@Param("ew") Wrapper<DiscussdaikuanchanpinEntity> wrapper);
}
