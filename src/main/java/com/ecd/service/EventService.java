package com.ecd.service;

import java.util.List;

import com.ecd.pojo.Event;

public interface EventService {

	// 录入事件信息
	public int insertEvent(Event event);

	// 删除事件信息
	public int deleteEventById(String uuid);

	// 根据查询所有事件信息
	public List<Event> selectAllEvent(int page);

	// 事件总的数目
	public int selectNumOfEvent();

	// 根据id查询单一事件信息
	public Event selectEventById(String uuid);

	// 修改事件信息
	public int updateEventById(Event event);

}
