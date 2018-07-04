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
import com.ecd.pojo.Person;
import com.ecd.pojo.VO;
import com.ecd.service.EventService;
import com.ecd.tool.PageResult;
import com.ecd.tool.Result;
import com.ecd.tool.TimeGet;

@Controller
public class EventController {

	@Autowired
	EventService eventService;

	/**
	 * 添加新的event
	 * 
	 * @param person
	 * @param event
	 * @return
	 */
	@RequestMapping(value = "/insertEvent", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public String insertEvent(@RequestBody String jsonString,HttpServletRequest request) {
//		Event event= JSON.parseObject(jsonString, Event.class);
//		Person person = (Person) request.getSession().getAttribute("person");
		VO vo= JSON.parseObject(jsonString, VO.class);
		System.out.println("------------------vo:"+vo);
		Event event = vo.getEvent();
		Person person = vo.getPerson();
		System.out.println("======================="+event+"============="+person);
		// 补充event中缺失的信息
		event.setEvent_logging_person(person.getName());
		event.setEvent_logging_time(TimeGet.getTime());
		// 执行添加操作
		int num = eventService.insertEvent(event);
		if (num == 1) {
			return Result.success().toJSONString();
		} else {
			return Result.failed().toJSONString();
		}
	}

	/**
	 * 查询所有的event
	 * 
	 * @param session
	 * @param page
	 * @return 返回数据：list，页数，总数，页码
	 */
	@RequestMapping(value = "/selectAllEvent", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String selectAllEvent(int page) {
		// 查询待注册用户信息
		List<Event> data = eventService.selectAllEvent(page);
		// 查询待注册用户数量
		int num = eventService.selectNumOfEvent();
		return PageResult.success(data, num / 5, num, page).toJSONString();
	}

	/**
	 * 查询单个详细事件
	 * 
	 * @param session
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value = "/selectEventById", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String selectEventById(String uuid) {
		// 根据email查询数据
		Event data = eventService.selectEventById(uuid);
		// 返回数据
		return Result.success(data).toJSONString();

	}

	/**
	 * 删除事件信息
	 * 
	 * @param session
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value = "/deleteEventById", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String deleteEventById(String uuid) {
		// 执行删除操作
		int num = eventService.deleteEventById(uuid);
		if (num == 1) {
			// 返回数据
			return Result.success().toJSONString();
		} else {
			return Result.failed("500", "删除失败").toJSONString();
		}

	}

	/**
	 * 更新事件信息
	 * 
	 * @param session
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value = "/updateEventById", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public String updateEventById(@RequestBody String jsonString) {
		VO vo= JSON.parseObject(jsonString, VO.class);
		Event event= vo.getEvent();
		Person person = vo.getPerson();
		System.out.println("打印========================" + person + " ===============" + event );
		// 执行更新操作
		event.setEvent_finish_person(person.getName());
		event.setEvent_finish_time(TimeGet.getTime());
		int num = eventService.updateEventById(event);
		if (num == 1) {
			// 返回数据
			return Result.success().toJSONString();
		} else {
			return Result.failed("500", "更新失败").toJSONString();
		}

	}
}
