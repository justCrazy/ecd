package com.ecd.tool;

import java.util.ArrayList;
import java.util.List;

public class ListResult<T> extends AbstractResult<T> {
	/**
	 * 返回数据
	 */
	private List<T> data = new ArrayList<>();

	private ListResult(boolean success) {
		this(success, null);
	}

	private ListResult(boolean success, List<T> data) {
		this(success, null, null, data);
	}

	private ListResult(boolean success, String errorCode, String description, List<T> data) {
		setSuccess(success);
		setErrorCode(errorCode);
		setDescription(description);
		this.data = data;

	}

	public static <T> ListResult<T> create(boolean success) {
		return new ListResult<>(success);
	}

	public static <T> ListResult<T> success() {
		return new ListResult<>(true);
	}

	public static <T> ListResult<T> success(List<T> data) {
		return new ListResult<>(true, data);
	}

	public static <T> ListResult<T> failed() {
		return new ListResult<>(false, null);
	}

	public static <T> ListResult<T> failed(String code, String description) {
		return new ListResult<>(false, code, description, null);
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
