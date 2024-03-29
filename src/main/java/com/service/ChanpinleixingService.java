package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChanpinleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChanpinleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanpinleixingView;


/**
 * 产品类型
 *
 */
public interface ChanpinleixingService extends IService<ChanpinleixingEntity> {
	//ISeervice ：业务逻辑层接口

    PageUtils queryPage(Map<String, Object> params); //分页工具
    
   	List<ChanpinleixingVO> selectListVO(Wrapper<ChanpinleixingEntity> wrapper);
   	
   	ChanpinleixingVO selectVO(@Param("ew") Wrapper<ChanpinleixingEntity> wrapper);
   	
   	List<ChanpinleixingView> selectListView(Wrapper<ChanpinleixingEntity> wrapper);
   	
   	ChanpinleixingView selectView(@Param("ew") Wrapper<ChanpinleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChanpinleixingEntity> wrapper);
}

