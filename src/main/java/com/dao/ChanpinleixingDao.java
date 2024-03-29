package com.dao; //数据访问层

import com.entity.ChanpinleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChanpinleixingVO;
import com.entity.view.ChanpinleixingView;


/**
 * 产品类型
 *
 */
public interface ChanpinleixingDao extends BaseMapper<ChanpinleixingEntity> {
	
	List<ChanpinleixingVO> selectListVO(@Param("ew") Wrapper<ChanpinleixingEntity> wrapper); //@param以传参；“ew”：entity wrapper：条件构造器
	
	ChanpinleixingVO selectVO(@Param("ew") Wrapper<ChanpinleixingEntity> wrapper);
	
	List<ChanpinleixingView> selectListView(@Param("ew") Wrapper<ChanpinleixingEntity> wrapper);

	List<ChanpinleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ChanpinleixingEntity> wrapper);
	
	ChanpinleixingView selectView(@Param("ew") Wrapper<ChanpinleixingEntity> wrapper);// selectList用于查询
}
