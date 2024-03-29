package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DaikuanbanliDao;
import com.entity.DaikuanbanliEntity;
import com.service.DaikuanbanliService;
import com.entity.vo.DaikuanbanliVO;
import com.entity.view.DaikuanbanliView;

@Service("daikuanbanliService")
public class DaikuanbanliServiceImpl extends ServiceImpl<DaikuanbanliDao, DaikuanbanliEntity> implements DaikuanbanliService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaikuanbanliEntity> page = this.selectPage(
                new Query<DaikuanbanliEntity>(params).getPage(),
                new EntityWrapper<DaikuanbanliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaikuanbanliEntity> wrapper) {
		  Page<DaikuanbanliView> page =new Query<DaikuanbanliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DaikuanbanliVO> selectListVO(Wrapper<DaikuanbanliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaikuanbanliVO selectVO(Wrapper<DaikuanbanliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaikuanbanliView> selectListView(Wrapper<DaikuanbanliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaikuanbanliView selectView(Wrapper<DaikuanbanliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
