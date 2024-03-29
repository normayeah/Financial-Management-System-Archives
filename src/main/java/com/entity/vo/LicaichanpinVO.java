package com.entity.vo;

import com.entity.LicaichanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 理财产品
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 */
public class LicaichanpinVO  implements Serializable {
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
	 * 产品详情
	 */
	
	private String chanpinxiangqing;
		
	/**
	 * 产品价格
	 */
	
	private Integer chanpinjiage;
		
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
	 * 设置：产品详情
	 */
	 
	public void setChanpinxiangqing(String chanpinxiangqing) {
		this.chanpinxiangqing = chanpinxiangqing;
	}
	
	/**
	 * 获取：产品详情
	 */
	public String getChanpinxiangqing() {
		return chanpinxiangqing;
	}
				
	
	/**
	 * 设置：产品价格
	 */
	 
	public void setChanpinjiage(Integer chanpinjiage) {
		this.chanpinjiage = chanpinjiage;
	}
	
	/**
	 * 获取：产品价格
	 */
	public Integer getChanpinjiage() {
		return chanpinjiage;
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
