package com.ecd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ecd.pojo.Notice;
import com.ecd.pojo.Person;
import com.ecd.pojo.VO;
import com.ecd.service.NoticeService;
import com.ecd.tool.PageResult;
import com.ecd.tool.Result;
import com.ecd.tool.TimeGet;

import java.util.List;

@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	/**
	 * 添加新的notice
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/insertNotice", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public String insertNotice(@RequestBody String jsonString) {
		VO vo = JSON.parseObject(jsonString, VO.class);
		// 补充notice中缺失的信息
		Person person = vo.getPerson();
		Notice notice = vo.getNotice();
		notice.setTime(TimeGet.getTime());
		notice.setNotice_person(person.getName());
		// 执行添加操作
		int num = noticeService.insertNotice(notice);
		if (num == 1) {
			return Result.success().toJSONString();
		} else {
			return Result.failed().toJSONString();
		}
	}

	/**
	 * 查询所有的notice
	 * 
	 * @param session
	 * @param page
	 * @return 返回数据：list，页数，总数，页码
	 */
	@RequestMapping(value = "/selectAllNotice", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String selectAllNotice(int page) {
		// 查询待注册用户信息
		List<Notice> data = noticeService.selectAllNotice(page);
		// 查询待注册用户数量
		int num = noticeService.selectNumOfNotice();
		return PageResult.success(data, num / 5, num, page).toJSONString();
	}

	/**
	 * 查询单个详细通知
	 * 
	 * @param session
	 * @param notice_id
	 * @return
	 */
	@RequestMapping(value = "/selectNoticeById", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String selectNoticeById(int notice_id) {
		// 根据email查询数据
		Notice data = noticeService.selectNoticeById(notice_id);
		// 返回数据
		return Result.success(data).toJSONString();

	}

	/**
	 * 删除公告信息
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/deleteNoticeById", produces = "application/text;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String deleteNoticeById(String notice_id) {
		int id = Integer.parseInt(notice_id);
		// 执行删除操作
		int num = noticeService.deleteNotice(id);
		if (num == 1) {
			// 返回数据
			return Result.success().toJSONString();
		} else {
			return Result.failed("500", "删除失败").toJSONString();
		}

	}
}
