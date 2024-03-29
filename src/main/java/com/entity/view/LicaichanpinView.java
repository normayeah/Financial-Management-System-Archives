package com.entity.view;

import com.entity.LicaichanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 理财产品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("licaichanpin")
public class LicaichanpinView  extends LicaichanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LicaichanpinView(){
	}
 
 	public LicaichanpinView(LicaichanpinEntity licaichanpinEntity){
 	try {
			BeanUtils.copyProperties(this, licaichanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
