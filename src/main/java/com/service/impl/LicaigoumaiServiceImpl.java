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


import com.dao.LicaigoumaiDao;
import com.entity.LicaigoumaiEntity;
import com.service.LicaigoumaiService;
import com.entity.vo.LicaigoumaiVO;
import com.entity.view.LicaigoumaiView;

@Service("licaigoumaiService")
public class LicaigoumaiServiceImpl extends ServiceImpl<LicaigoumaiDao, LicaigoumaiEntity> implements LicaigoumaiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LicaigoumaiEntity> page = this.selectPage(
                new Query<LicaigoumaiEntity>(params).getPage(),
                new EntityWrapper<LicaigoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LicaigoumaiEntity> wrapper) {
		  Page<LicaigoumaiView> page =new Query<LicaigoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LicaigoumaiVO> selectListVO(Wrapper<LicaigoumaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LicaigoumaiVO selectVO(Wrapper<LicaigoumaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LicaigoumaiView> selectListView(Wrapper<LicaigoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LicaigoumaiView selectView(Wrapper<LicaigoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
