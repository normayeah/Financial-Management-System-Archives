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


import com.dao.DiscusslicaichanpinDao;
import com.entity.DiscusslicaichanpinEntity;
import com.service.DiscusslicaichanpinService;
import com.entity.vo.DiscusslicaichanpinVO;
import com.entity.view.DiscusslicaichanpinView;

@Service("discusslicaichanpinService")
public class DiscusslicaichanpinServiceImpl extends ServiceImpl<DiscusslicaichanpinDao, DiscusslicaichanpinEntity> implements DiscusslicaichanpinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusslicaichanpinEntity> page = this.selectPage(
                new Query<DiscusslicaichanpinEntity>(params).getPage(),
                new EntityWrapper<DiscusslicaichanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusslicaichanpinEntity> wrapper) {
		  Page<DiscusslicaichanpinView> page =new Query<DiscusslicaichanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusslicaichanpinVO> selectListVO(Wrapper<DiscusslicaichanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusslicaichanpinVO selectVO(Wrapper<DiscusslicaichanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusslicaichanpinView> selectListView(Wrapper<DiscusslicaichanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusslicaichanpinView selectView(Wrapper<DiscusslicaichanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
