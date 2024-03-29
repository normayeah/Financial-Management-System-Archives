package com.entity.model;

import com.entity.DaikuanchanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 贷款产品
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 */
public class DaikuanchanpinModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
