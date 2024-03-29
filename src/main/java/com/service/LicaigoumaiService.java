package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LicaigoumaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LicaigoumaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LicaigoumaiView;


/**
 * 理财购买
 *
 */
public interface LicaigoumaiService extends IService<LicaigoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LicaigoumaiVO> selectListVO(Wrapper<LicaigoumaiEntity> wrapper);
   	
   	LicaigoumaiVO selectVO(@Param("ew") Wrapper<LicaigoumaiEntity> wrapper);
   	
   	List<LicaigoumaiView> selectListView(Wrapper<LicaigoumaiEntity> wrapper);
   	
   	LicaigoumaiView selectView(@Param("ew") Wrapper<LicaigoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LicaigoumaiEntity> wrapper);
}

