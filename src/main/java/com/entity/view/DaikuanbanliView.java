package com.entity.view;

import com.entity.DaikuanbanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 贷款办理
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("daikuanbanli")
public class DaikuanbanliView  extends DaikuanbanliEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DaikuanbanliView(){
	}
 
 	public DaikuanbanliView(DaikuanbanliEntity daikuanbanliEntity){
 	try {
			BeanUtils.copyProperties(this, daikuanbanliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
