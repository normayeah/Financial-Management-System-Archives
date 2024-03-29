package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DaikuanchanpinEntity;
import com.entity.view.DaikuanchanpinView;

import com.service.DaikuanchanpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 贷款产品
 * 后端接口
 */
@RestController
@RequestMapping("/daikuanchanpin")
public class DaikuanchanpinController {
    @Autowired
    private DaikuanchanpinService daikuanchanpinService;
    

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaikuanchanpinEntity daikuanchanpin, HttpServletRequest request){

        EntityWrapper<DaikuanchanpinEntity> ew = new EntityWrapper<DaikuanchanpinEntity>();
		PageUtils page = daikuanchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daikuanchanpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaikuanchanpinEntity daikuanchanpin, HttpServletRequest request){
        EntityWrapper<DaikuanchanpinEntity> ew = new EntityWrapper<DaikuanchanpinEntity>();
		PageUtils page = daikuanchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daikuanchanpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaikuanchanpinEntity daikuanchanpin){
       	EntityWrapper<DaikuanchanpinEntity> ew = new EntityWrapper<DaikuanchanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daikuanchanpin, "daikuanchanpin")); 
        return R.ok().put("data", daikuanchanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaikuanchanpinEntity daikuanchanpin){
        EntityWrapper< DaikuanchanpinEntity> ew = new EntityWrapper< DaikuanchanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daikuanchanpin, "daikuanchanpin")); 
		DaikuanchanpinView daikuanchanpinView =  daikuanchanpinService.selectView(ew);
		return R.ok("查询贷款产品成功").put("data", daikuanchanpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        DaikuanchanpinEntity daikuanchanpin = daikuanchanpinService.selectById(id);
        return R.ok().put("data", daikuanchanpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        DaikuanchanpinEntity daikuanchanpin = daikuanchanpinService.selectById(id);
        return R.ok().put("data", daikuanchanpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaikuanchanpinEntity daikuanchanpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(daikuanchanpin);

        daikuanchanpinService.insert(daikuanchanpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaikuanchanpinEntity daikuanchanpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(daikuanchanpin);

        daikuanchanpinService.insert(daikuanchanpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DaikuanchanpinEntity daikuanchanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daikuanchanpin);
        daikuanchanpinService.updateById(daikuanchanpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daikuanchanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DaikuanchanpinEntity> wrapper = new EntityWrapper<DaikuanchanpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = daikuanchanpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

}
