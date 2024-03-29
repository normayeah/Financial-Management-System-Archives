
package com.entity;

/**
 * 自定义异常 统一处理
 */
public class EIException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public EIException(String msg) {//super:在子类指代父类
		super(msg);//super(“父类参数”),调用父类参数
		this.msg = msg;
	}
	
	public EIException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public EIException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public EIException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
