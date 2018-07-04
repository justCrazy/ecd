package com.ecd.tool;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> extends AbstractResult<T> {
	/**
	 * 返回数据
	 */
	private List<T> data = new ArrayList<>();
	/**
	 * 总数
	 */
	private long total;
	/**
	 * 总页数
	 */
	private int pages;
	/**
	 * 当前页
	 */
	private int pageNum;

	private PageResult(boolean success) {
		this(success, null);
	}

	private PageResult(boolean success, List<T> data) {
		this(success, null, null, data);
	}

	private PageResult(boolean success, String errorCode, String description, List<T> data) {
		setSuccess(success);
		setErrorCode(errorCode);
		setDescription(description);
		this.data = data;
	}

	private PageResult(boolean success, List<T> data, int pages, int total, int pageNum) {
		setSuccess(success);
		this.data = data;
		setPages(pages);
		setTotal(total);
		setPageNum(pageNum);
	}

	/**
	 * 调用此方法后因立即设置pages和total eg: PageResult.pages(pages)
	 * 
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> PageResult<T> success(List<T> data) {
		return new PageResult<>(true, data);
	}

	public static <T> PageResult<T> success(List<T> data, int pages, int total, int pageNum) {
		return new PageResult<>(true, data, pages, total, pageNum);
	}

	public static <T> PageResult<T> failed() {
		return new PageResult<>(false);
	}

	public static <T> PageResult<T> failed(String code, String description) {
		return new PageResult<>(false, code, description, null);
	}

	public PageResult<T> pages(int pages) {
		this.setPages(pages);
		return this;
	}

	public PageResult<T> total(long total) {
		this.setTotal(total);
		return this;
	}

	public PageResult<T> pagesNum(int pageNum) {
		this.setPageNum(pageNum);
		return this;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
