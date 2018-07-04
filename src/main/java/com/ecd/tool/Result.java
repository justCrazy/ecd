package com.ecd.tool;

public class Result<T> extends AbstractResult<T> {
	/**
	 * 返回数据
	 */
	private T data;

	private Result(boolean success) {
		this(success, null);
	}

	private Result(boolean success, T data) {
		this(success, null, null, data);
	}

	private Result(boolean success, String errorCode, String description, T data) {
		setSuccess(success);
		setErrorCode(errorCode);
		setDescription(description);
		this.data = data;

	}

	public static <T> Result<T> create(boolean success) {
		return new Result<T>(success);
	}

	public static <T> Result<T> success() {
		return new Result<>(true);
	}

	public static <T> Result<T> success(T data) {
		return new Result<>(true, data);
	}

	public static <T> Result<T> success(String code, String description, T data) {
		return new Result<>(true, code, description, data);
	}

	public static <T> Result<T> failed() {
		return new Result<>(false, null);
	}

	public static <T> Result<T> failed(String code, String description) {
		return new Result<>(false, code, description, null);
	}

	public static <T> Result<T> failed(String code, String description, T data) {
		return new Result<>(false, code, description, data);
	}

	public Result<T> code(String code) {
		this.setErrorCode(code);
		return this;
	}

	public Result<T> description(String description) {
		this.setDescription(description);
		return this;
	}

	public Result<T> data(T data) {
		this.data = data;
		return this;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
