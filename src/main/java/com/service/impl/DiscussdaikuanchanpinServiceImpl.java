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


import com.dao.DiscussdaikuanchanpinDao;
import com.entity.DiscussdaikuanchanpinEntity;
import com.service.DiscussdaikuanchanpinService;
import com.entity.vo.DiscussdaikuanchanpinVO;
import com.entity.view.DiscussdaikuanchanpinView;

@Service("discussdaikuanchanpinService")
public class DiscussdaikuanchanpinServiceImpl extends ServiceImpl<DiscussdaikuanchanpinDao, DiscussdaikuanchanpinEntity> implements DiscussdaikuanchanpinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdaikuanchanpinEntity> page = this.selectPage(
                new Query<DiscussdaikuanchanpinEntity>(params).getPage(),
                new EntityWrapper<DiscussdaikuanchanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdaikuanchanpinEntity> wrapper) {
		  Page<DiscussdaikuanchanpinView> page =new Query<DiscussdaikuanchanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdaikuanchanpinVO> selectListVO(Wrapper<DiscussdaikuanchanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdaikuanchanpinVO selectVO(Wrapper<DiscussdaikuanchanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdaikuanchanpinView> selectListView(Wrapper<DiscussdaikuanchanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdaikuanchanpinView selectView(Wrapper<DiscussdaikuanchanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
