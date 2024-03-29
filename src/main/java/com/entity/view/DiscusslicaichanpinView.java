package com.entity.view;

import com.entity.DiscusslicaichanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 理财产品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 */
@TableName("discusslicaichanpin")
public class DiscusslicaichanpinView  extends DiscusslicaichanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusslicaichanpinView(){
	}
 
 	public DiscusslicaichanpinView(DiscusslicaichanpinEntity discusslicaichanpinEntity){
 	try {
			BeanUtils.copyProperties(this, discusslicaichanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
