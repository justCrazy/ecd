package com.ecd.dao;

import java.util.List;

import com.ecd.pojo.Event;

public interface EventDao {

	/**
	 * 录入事件操作 操作者：执法人员
	 * 
	 * @param event
	 * @return int 数据库：event
	 */
	// 录入事件信息
	public int insertEvent(Event event);

	/**
	 * 删除事件操作 操作者：环保人员
	 * 
	 * @param event
	 * @return int 数据库：event
	 */
	// 删除事件信息
	public int deleteEventById(String uuid);

	/**
	 * 查看多条事件操作 * 操作者：环保人员
	 * 
	 * @param 页码
	 * @return event的类list
	 */
	// 根据查询所有事件信息
	public List<Event> selectAllEvent(int page);

	/**
	 * 查看事件总数目 操作者：环保人员
	 * 
	 * @param
	 * @return int
	 */
	// 事件总的数目
	public int selectNumOfEvent();

	/**
	 * 查看详细事件操作 操作者：所有操作人员
	 * 
	 * @param uuid
	 * @return person类
	 */
	// 根据id查询单一事件信息
	public Event selectEventById(String uuid);

	/**
	 * 修改事件操作 操作者：执法人员
	 * 
	 * @param event
	 * @return int 数据库：event
	 */
	// 修改事件信息
	public int updateEventById(Event event);

}
