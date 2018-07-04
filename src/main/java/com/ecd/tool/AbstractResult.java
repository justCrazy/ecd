package com.ecd.tool;

import com.alibaba.fastjson.JSON;

public abstract class AbstractResult<T> {
	/**
	 * 状态码，是否成功
	 */
	private boolean success;

	/**
	 * 错误代码
	 */
	private String errorCode;

	/**
	 * 错误描述
	 */
	private String description;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toJSONString() {
		return JSON.toJSONString(this);
	}
}
