
package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.UserEntity;
import com.utils.PageUtils;


public interface UserService extends IService<UserEntity> {
	//IService:Service层通用接口，有一定规范
 	PageUtils queryPage(Map<String, Object> params);
	 //分页工具类（mybatis-plus提供）；接受一个名为params的 Map对象作为参数，返回一个PageUtils对象。
    
   	List<UserEntity> selectListView(Wrapper<UserEntity> wrapper);
   	//查询返回多条数据(List<T> 集合)；
	// Wrapper:条件构造器，构建SQL查询
	//SelectListView是一种常见的UI控件，它可以让用户从一个列表中选择一个或多个选项。
   	PageUtils queryPage(Map<String, Object> params,Wrapper<UserEntity> wrapper);
	   // Wrapper:条件构造抽象类，最顶端父类
	//分页对象中的Map作为参数查询
	   	
}
