package com.ecd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecd.dao.NoticeDao;
import com.ecd.pojo.Notice;
import com.ecd.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;

	/**
	 * 将新的通知添加到数据库中 返回是否插入成功
	 */
	public int insertNotice(Notice notice) {
		return noticeDao.insertNotice(notice);
	}

	/**
	 * 查询所有的通知 返回List<Notice>
	 */
	public List<Notice> selectAllNotice(int page) {
		return noticeDao.selectAllNotice((page - 1) * 5);
	}

	/**
	 * 查询通知的总数 返回通知的数量
	 */
	public int selectNumOfNotice() {
		return noticeDao.selectNumOfNotice();
	}

	/**
	 * 查询单个通知 返回notice类
	 */
	public Notice selectNoticeById(int notice_id) {
		return noticeDao.selectNoticeById(notice_id);
	}

	/**
	 * 删除通知 返回是否删除成功
	 */
	public int deleteNotice(int notice_id) {
		return noticeDao.deleteNotice(notice_id);
	}

}
