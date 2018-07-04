package com.ecd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ecd.pojo.Event;
import com.ecd.pojo.MapToDo;
import com.ecd.pojo.Person;
import com.ecd.pojo.VO;
import com.ecd.service.MapToDoService;
import com.ecd.tool.PageResult;
import com.ecd.tool.Result;

@Controller
public class MapToDoController {

	@Autowired
	MapToDoService mapToDoService;

	/**
	 * 添加新的待办件
	 * 
	 * @param event
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/insertMapToDo", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public String insertMapToDo(@RequestBody String jsonString) {
		VO vo= JSON.parseObject(jsonString, VO.class);
		System.out.println("------------------vo:"+vo);
		Event event = vo.getEvent();
		Person person = vo.getPerson();
		System.out.println("======================="+event+"============="+person);
		MapToDo mapToDo = new MapToDo();
		// 补充notice中缺失的信息
		mapToDo.setMap2Do_event_id(event.getEvent_id());
		mapToDo.setMap2Do_email(person.getEmail());
		mapToDo.setMap2Do_name(person.getName());
		mapToDo.setMap2Do_event_description(event.getEvent_description());
		mapToDo.setMap2Do_event_address(event.getEvent_description());
		mapToDo.setMap2Do_event_time(event.getEvent_time());
		// 设置邮件信息
		String context = mapToDo.getMap2Do_name()+"您好，您有一件新的任务添加到你的待办件中，请注意查看";
		// 执行添加操作
		int num = mapToDoService.insertMapToDo(mapToDo);
		if (num == 1) {
			// 发送邮件
			mapToDoService.sendMapToDoMessage(context, person.getEmail());
			return Result.success().toJSONString();
		} else {
			return Result.failed().toJSONString();
		}

	}

	/**
	 * 查询所有的mapToDo
	 * 
	 * @param email
	 * @param page
	 * @return 返回数据：list，页数，总数，页码
	 */
	@RequestMapping(value = "/selectAllMapToDo", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String selectAllMapToDo(String email, int page) {
		// 查询待注册用户信息
		List<MapToDo> data = mapToDoService.selectAllMapToDo(email, page);
		// 查询待注册用户数量
		int num = mapToDoService.selectNumOfMapToDo(email);
		return PageResult.success(data, num / 5, num, page).toJSONString();
	}

	/**
	 * 查询单个详细事件（在event中添加）
	 * 
	 * @param session
	 * @param notice_id
	 * @return
	 */
	// @RequestMapping(value = "/selectNoticeById")
	// @ResponseBody
	// public String selectNoticeById(HttpSession session, int map2Do_event_id) {
	// // 根据email查询数据
	// Notice data = noticeService.selectNoticeById(notice_id);
	// // 返回数据
	// return Result.success(data).toJSONString();
	//
	// }

	/**
	 * 删除待办件信息
	 * 
	 * @param session
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/deleteMapToDo", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String deleteMapToDo(String uuid) {
		// 执行删除操作
		int num = mapToDoService.deleteMapToDo(uuid);
		if (num == 1) {
			// 返回数据
			return Result.success().toJSONString();
		} else {
			return Result.failed("500", "删除失败").toJSONString();
		}

	}
}
