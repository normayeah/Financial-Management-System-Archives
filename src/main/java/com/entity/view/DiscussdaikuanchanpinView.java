package com.entity.view;

import com.entity.DiscussdaikuanchanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 贷款产品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 */
@TableName("discussdaikuanchanpin")
public class DiscussdaikuanchanpinView  extends DiscussdaikuanchanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussdaikuanchanpinView(){
	}
 
 	public DiscussdaikuanchanpinView(DiscussdaikuanchanpinEntity discussdaikuanchanpinEntity){
 	try {
			BeanUtils.copyProperties(this, discussdaikuanchanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
