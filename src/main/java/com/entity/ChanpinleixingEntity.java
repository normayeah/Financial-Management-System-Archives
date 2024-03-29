package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 产品类型
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("chanpinleixing") //映射到该名字的数据库表，实体类和数据库表的映射
public class ChanpinleixingEntity<T> implements Serializable {  //Serializable：使得实体序列化（保存属性到硬盘/网络传输）
	private static final long serialVersionUID = 1L;//标识可序列化类的版本，再次编译变2L


	public ChanpinleixingEntity() {
		
	}
	
	public ChanpinleixingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t); //BeanUtils.copyProperperties（转换前的类，转换后的类）:拷贝属性
			//两个具有很多相同属性的JavaBean，需要对象之间的赋值时使用
		} catch (IllegalAccessException | InvocationTargetException e) {
			//IllegalAccessException：表示没有访问权限的异常
			//InvocationTargetException:被调用方法内部抛出的异常没被捕获时，抛出此异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 类型
	 */
					
	private String leixing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")//@JsonFormat：时间格式化（yyyy-MM-dd HH:mm:ss样式的时间）（locale:地域文字显示，timezone:时区，pattern:时间显示模式）
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：类型
	 */
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}

}
