package com.dao;

import com.entity.LicaigoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LicaigoumaiVO;
import com.entity.view.LicaigoumaiView;


/**
 * 理财购买
 *
 */
public interface LicaigoumaiDao extends BaseMapper<LicaigoumaiEntity> {
	
	List<LicaigoumaiVO> selectListVO(@Param("ew") Wrapper<LicaigoumaiEntity> wrapper);
	
	LicaigoumaiVO selectVO(@Param("ew") Wrapper<LicaigoumaiEntity> wrapper);
	
	List<LicaigoumaiView> selectListView(@Param("ew") Wrapper<LicaigoumaiEntity> wrapper);

	List<LicaigoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<LicaigoumaiEntity> wrapper);
	
	LicaigoumaiView selectView(@Param("ew") Wrapper<LicaigoumaiEntity> wrapper);
}
