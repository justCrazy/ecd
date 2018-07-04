package com.ecd.dao;

import java.util.List;

import com.ecd.pojo.Notice;

public interface NoticeDao {

	/**
	 * 添加通知操作 操作者：环保人员
	 * 
	 * @param
	 * @return int 数据库：Notice
	 */
	// 将新的通知添加到数据库中
	public int insertNotice(Notice notice);

	/**
	 * 查看所有通知操作 操作者：所有人员
	 * 
	 * @param
	 * @return notice的list集合 数据库：Notice
	 */
	// 查询所有的通知
	public List<Notice> selectAllNotice(int page);

	/**
	 * 查看通知数目操作 操作者：所有人员
	 * 
	 * @param
	 * @return int 数据库：Notice
	 */
	// 查询通知的总数
	public int selectNumOfNotice();

	/**
	 * 查询单个通知操作 操作者：环保人员
	 * 
	 * @param String
	 * @return int 数据库：Notice
	 */
	// 查询单个通知
	public Notice selectNoticeById(int notice_id);

	/**
	 * 删除通知操作 操作者：环保人员
	 * 
	 * @param String
	 * @return int 数据库：Notice
	 */
	// 删除通知
	public int deleteNotice(int notice_id);

}
