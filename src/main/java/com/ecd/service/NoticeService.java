package com.ecd.service;

import java.util.List;

import com.ecd.pojo.Notice;

public interface NoticeService {

	// 将新的通知添加到数据库中
	public int insertNotice(Notice notice);

	// 查询所有的通知
	public List<Notice> selectAllNotice(int page);

	// 查询通知的总数
	public int selectNumOfNotice();

	// 查询单个通知
	public Notice selectNoticeById(int notice_id);

	// 删除通知
	public int deleteNotice(int notice_id);

}
