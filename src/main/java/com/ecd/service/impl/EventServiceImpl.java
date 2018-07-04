
package com.ecd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecd.dao.EventDao;
import com.ecd.pojo.Event;
import com.ecd.service.EventService;

@Service("eventService")
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;

	/**
	 * 录入事件信息 返回是否插入成功
	 */
	public int insertEvent(Event event) {
		return eventDao.insertEvent(event);
	}

	/**
	 * 删除事件信息 返回是否删除成功
	 */
	public int deleteEventById(String uuid) {
		return eventDao.deleteEventById(uuid);
	}

	/**
	 * 查询所有事件信息 返回List<Event>
	 */
	public List<Event> selectAllEvent(int page) {
		return eventDao.selectAllEvent((page - 1) * 5);
	}

	/**
	 * 查询事件总的数目 返回数目
	 */
	public int selectNumOfEvent() {
		return eventDao.selectNumOfEvent();
	}

	/**
	 * 根据id查询单一事件信息 返回event
	 */
	public Event selectEventById(String uuid) {
		return eventDao.selectEventById(uuid);
	}

	/**
	 * 修改事件信息 返回是否更改成功
	 */
	public int updateEventById(Event event) {
		return eventDao.updateEventById(event);
	}

}
