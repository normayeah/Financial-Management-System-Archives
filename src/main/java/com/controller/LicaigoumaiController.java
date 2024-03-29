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

import com.entity.LicaigoumaiEntity;
import com.entity.view.LicaigoumaiView;

import com.service.LicaigoumaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 理财购买
 * 后端接口
 */
@RestController
@RequestMapping("/licaigoumai")
public class LicaigoumaiController {
    @Autowired
    private LicaigoumaiService licaigoumaiService;
    

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LicaigoumaiEntity licaigoumai, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiyuan")) {
			licaigoumai.setNicheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LicaigoumaiEntity> ew = new EntityWrapper<LicaigoumaiEntity>();
		PageUtils page = licaigoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, licaigoumai), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LicaigoumaiEntity licaigoumai, HttpServletRequest request){
        EntityWrapper<LicaigoumaiEntity> ew = new EntityWrapper<LicaigoumaiEntity>();
		PageUtils page = licaigoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, licaigoumai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LicaigoumaiEntity licaigoumai){
       	EntityWrapper<LicaigoumaiEntity> ew = new EntityWrapper<LicaigoumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( licaigoumai, "licaigoumai")); 
        return R.ok().put("data", licaigoumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LicaigoumaiEntity licaigoumai){
        EntityWrapper< LicaigoumaiEntity> ew = new EntityWrapper< LicaigoumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( licaigoumai, "licaigoumai")); 
		LicaigoumaiView licaigoumaiView =  licaigoumaiService.selectView(ew);
		return R.ok("查询理财购买成功").put("data", licaigoumaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        LicaigoumaiEntity licaigoumai = licaigoumaiService.selectById(id);
        return R.ok().put("data", licaigoumai);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        LicaigoumaiEntity licaigoumai = licaigoumaiService.selectById(id);
        return R.ok().put("data", licaigoumai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LicaigoumaiEntity licaigoumai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(licaigoumai);

        licaigoumaiService.insert(licaigoumai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LicaigoumaiEntity licaigoumai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(licaigoumai);

        licaigoumaiService.insert(licaigoumai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LicaigoumaiEntity licaigoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(licaigoumai);
        licaigoumaiService.updateById(licaigoumai);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        licaigoumaiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<LicaigoumaiEntity> wrapper = new EntityWrapper<LicaigoumaiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiyuan")) {
			wrapper.eq("nicheng", (String)request.getSession().getAttribute("username"));
		}

		int count = licaigoumaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

}
