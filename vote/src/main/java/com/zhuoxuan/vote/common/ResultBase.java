package com.zhuoxuan.vote.common;

import java.io.Serializable;

/**
 * 
 * <p>
 *  用户中心业务层结果返回对象
 * </p>
 * 
 * @author 卓轩
 * @创建时间：2014年4月24日
 * @version： V1.0
 */
public class ResultBase<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5253088541261601932L;

	/**
	 * 方法调用是否成功
	 */
	private boolean isSuccess = false;

	/**
	 * 错误消息
	 */
	private String errorMsg = "";

	/**
	 * 错误代码
	 */
	private int errorCode = 0;

	/**
	 * 返回的对象
	 */
	private T value;

	/**
	 * 总记录数
	 */
	private int count;
	
	

	public ResultBase() {
		super();
	}
	
	/**
	 * @param value
	 * @return
	 */
	public ResultBase<T> setReturnRightValue(T value){
		this.setSuccess(true);
		this.setValue(value);
		return this;
	}
	
	/**
	 * @param value
	 * @return
	 */
	public ResultBase<T> setReturnErrorMsg(String value){
		this.setSuccess(false);
		this.setErrorMsg(value);
		return this;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
