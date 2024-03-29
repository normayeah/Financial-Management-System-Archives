package com.dao;

import com.entity.LicaichanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LicaichanpinVO;
import com.entity.view.LicaichanpinView;


/**
 * 理财产品
 *
 */
public interface LicaichanpinDao extends BaseMapper<LicaichanpinEntity> {
	
	List<LicaichanpinVO> selectListVO(@Param("ew") Wrapper<LicaichanpinEntity> wrapper);
	
	LicaichanpinVO selectVO(@Param("ew") Wrapper<LicaichanpinEntity> wrapper);
	
	List<LicaichanpinView> selectListView(@Param("ew") Wrapper<LicaichanpinEntity> wrapper);

	List<LicaichanpinView> selectListView(Pagination page,@Param("ew") Wrapper<LicaichanpinEntity> wrapper);
	
	LicaichanpinView selectView(@Param("ew") Wrapper<LicaichanpinEntity> wrapper);
}
