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
 * 贷款产品
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("daikuanchanpin") //实体类和数据库表的映射
public class DaikuanchanpinEntity<T> implements Serializable { //Serializable：使得实体序列化（保存属性到硬盘/网络传输）
	//<T>:是泛型的默认值，可以被任意类型所代替
	private static final long serialVersionUID = 1L; //标识可序列化类的版本，再次编译变2L


	public DaikuanchanpinEntity() {
		//无参构造
	}
	
	public DaikuanchanpinEntity(T t) {//泛型可以让代码复用
		try {
			BeanUtils.copyProperties(this, t); //BeanUtils.copyProperperties（转换前的类，转换后的类）:拷贝属性
		} catch (IllegalAccessException | InvocationTargetException e) {
			//IllegalAccessException：表示没有访问权限的异常
			//InvocationTargetException:被调用方法内部抛出的异常没被捕获时，抛出此异常
			// TODO Auto-generated catch block
			e.printStackTrace();//printStackTrace()打印异常信息及位置
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)//@TableId：对应实体类的数据库表的主键属性；写法：@TableId(value=“数据库主键字段”,type = IdType.六种类型之一)；IdType.AUTO：数据库自增；数据库上也要勾上自增
	private Long id;
	/**
	 * 产品名称
	 */
					
	private String chanpinmingcheng;
	
	/**
	 * 类型
	 */
					
	private String leixing;
	
	/**
	 * 产品附图
	 */
					
	private String chanpinfutu;
	
	/**
	 * 产品介绍
	 */
					
	private String chanpinjieshao;
	
	/**
	 * 贷款金额
	 */
					
	private Integer daikuanjine;
	
	/**
	 * 优惠条件
	 */
					
	private String youhuitiaojian;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss") //@JsonFormat：时间格式化（yyyy-MM-dd HH:mm:ss样式的时间）（locale:地域文字显示，timezone:时区，pattern:时间显示模式）
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
	 * 设置：产品名称
	 */
	public void setChanpinmingcheng(String chanpinmingcheng) {
		this.chanpinmingcheng = chanpinmingcheng;
	}
	/**
	 * 获取：产品名称
	 */
	public String getChanpinmingcheng() {
		return chanpinmingcheng;
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
	/**
	 * 设置：产品附图
	 */
	public void setChanpinfutu(String chanpinfutu) {
		this.chanpinfutu = chanpinfutu;
	}
	/**
	 * 获取：产品附图
	 */
	public String getChanpinfutu() {
		return chanpinfutu;
	}
	/**
	 * 设置：产品介绍
	 */
	public void setChanpinjieshao(String chanpinjieshao) {
		this.chanpinjieshao = chanpinjieshao;
	}
	/**
	 * 获取：产品介绍
	 */
	public String getChanpinjieshao() {
		return chanpinjieshao;
	}
	/**
	 * 设置：贷款金额
	 */
	public void setDaikuanjine(Integer daikuanjine) {
		this.daikuanjine = daikuanjine;
	}
	/**
	 * 获取：贷款金额
	 */
	public Integer getDaikuanjine() {
		return daikuanjine;
	}
	/**
	 * 设置：优惠条件
	 */
	public void setYouhuitiaojian(String youhuitiaojian) {
		this.youhuitiaojian = youhuitiaojian;
	}
	/**
	 * 获取：优惠条件
	 */
	public String getYouhuitiaojian() {
		return youhuitiaojian;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}

}
