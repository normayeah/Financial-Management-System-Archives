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


import com.dao.LicaichanpinDao;
import com.entity.LicaichanpinEntity;
import com.service.LicaichanpinService;
import com.entity.vo.LicaichanpinVO;
import com.entity.view.LicaichanpinView;

@Service("licaichanpinService")
public class LicaichanpinServiceImpl extends ServiceImpl<LicaichanpinDao, LicaichanpinEntity> implements LicaichanpinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LicaichanpinEntity> page = this.selectPage(
                new Query<LicaichanpinEntity>(params).getPage(),
                new EntityWrapper<LicaichanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LicaichanpinEntity> wrapper) {
		  Page<LicaichanpinView> page =new Query<LicaichanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LicaichanpinVO> selectListVO(Wrapper<LicaichanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LicaichanpinVO selectVO(Wrapper<LicaichanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LicaichanpinView> selectListView(Wrapper<LicaichanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LicaichanpinView selectView(Wrapper<LicaichanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
