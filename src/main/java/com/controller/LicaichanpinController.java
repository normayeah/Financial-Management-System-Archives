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

import com.entity.LicaichanpinEntity;
import com.entity.view.LicaichanpinView;

import com.service.LicaichanpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 理财产品
 * 后端接口
 */
@RestController
@RequestMapping("/licaichanpin")
public class LicaichanpinController {
    @Autowired
    private LicaichanpinService licaichanpinService;
    

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LicaichanpinEntity licaichanpin, HttpServletRequest request){

        EntityWrapper<LicaichanpinEntity> ew = new EntityWrapper<LicaichanpinEntity>();
		PageUtils page = licaichanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, licaichanpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LicaichanpinEntity licaichanpin, HttpServletRequest request){
        EntityWrapper<LicaichanpinEntity> ew = new EntityWrapper<LicaichanpinEntity>();
		PageUtils page = licaichanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, licaichanpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LicaichanpinEntity licaichanpin){
       	EntityWrapper<LicaichanpinEntity> ew = new EntityWrapper<LicaichanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( licaichanpin, "licaichanpin")); 
        return R.ok().put("data", licaichanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LicaichanpinEntity licaichanpin){
        EntityWrapper< LicaichanpinEntity> ew = new EntityWrapper< LicaichanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( licaichanpin, "licaichanpin")); 
		LicaichanpinView licaichanpinView =  licaichanpinService.selectView(ew);
		return R.ok("查询理财产品成功").put("data", licaichanpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        LicaichanpinEntity licaichanpin = licaichanpinService.selectById(id);
        return R.ok().put("data", licaichanpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        LicaichanpinEntity licaichanpin = licaichanpinService.selectById(id);
        return R.ok().put("data", licaichanpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LicaichanpinEntity licaichanpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(licaichanpin);

        licaichanpinService.insert(licaichanpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LicaichanpinEntity licaichanpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(licaichanpin);

        licaichanpinService.insert(licaichanpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LicaichanpinEntity licaichanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(licaichanpin);
        licaichanpinService.updateById(licaichanpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        licaichanpinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<LicaichanpinEntity> wrapper = new EntityWrapper<LicaichanpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = licaichanpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

}
