package com.dao;

import com.entity.DiscusslicaichanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslicaichanpinVO;
import com.entity.view.DiscusslicaichanpinView;


/**
 * 理财产品评论表
 *
 */
public interface DiscusslicaichanpinDao extends BaseMapper<DiscusslicaichanpinEntity> {
	
	List<DiscusslicaichanpinVO> selectListVO(@Param("ew") Wrapper<DiscusslicaichanpinEntity> wrapper);
	
	DiscusslicaichanpinVO selectVO(@Param("ew") Wrapper<DiscusslicaichanpinEntity> wrapper);
	
	List<DiscusslicaichanpinView> selectListView(@Param("ew") Wrapper<DiscusslicaichanpinEntity> wrapper);

	List<DiscusslicaichanpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslicaichanpinEntity> wrapper);
	
	DiscusslicaichanpinView selectView(@Param("ew") Wrapper<DiscusslicaichanpinEntity> wrapper);
}
