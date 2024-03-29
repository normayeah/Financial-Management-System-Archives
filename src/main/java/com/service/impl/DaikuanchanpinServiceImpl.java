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


import com.dao.DaikuanchanpinDao;
import com.entity.DaikuanchanpinEntity;
import com.service.DaikuanchanpinService;
import com.entity.vo.DaikuanchanpinVO;
import com.entity.view.DaikuanchanpinView;

@Service("daikuanchanpinService")
public class DaikuanchanpinServiceImpl extends ServiceImpl<DaikuanchanpinDao, DaikuanchanpinEntity> implements DaikuanchanpinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaikuanchanpinEntity> page = this.selectPage(
                new Query<DaikuanchanpinEntity>(params).getPage(),
                new EntityWrapper<DaikuanchanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaikuanchanpinEntity> wrapper) {
		  Page<DaikuanchanpinView> page =new Query<DaikuanchanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DaikuanchanpinVO> selectListVO(Wrapper<DaikuanchanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaikuanchanpinVO selectVO(Wrapper<DaikuanchanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaikuanchanpinView> selectListView(Wrapper<DaikuanchanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaikuanchanpinView selectView(Wrapper<DaikuanchanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
