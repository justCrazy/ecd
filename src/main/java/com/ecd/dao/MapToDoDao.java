package com.ecd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ecd.pojo.MapToDo;

public interface MapToDoDao {

	/**
	 * 添加待办件操作 操作者：环保人员
	 * 
	 * @param Person
	 * @return int 数据库：MapToDo
	 */
	// 将新的待办件添加到数据库中的
	public int insertMapToDo(MapToDo mapToDo);

	/**
	 * 查询所有待办件操作 操作者：执法人员
	 * 
	 * @param String
	 *            email，String page
	 * @return MapToDo的list集合 数据库：MapToDo
	 */
	// 根据查看数据库中的待办件
	public List<MapToDo> selectAllMapToDo(@Param("map2Do_email") String map2Do_email, @Param("page") int page);

	/**
	 * 查询待办件数目操作 操作者：执法人员
	 * 
	 * @param String
	 * @return int 数据库：MapToDo
	 */
	// 根据查看数据库中的待办件数目
	public int selectNumOfMapToDo(String name);

	/**
	 * 删除待办件数目操作 操作者：执法人员
	 * 
	 * @param String
	 * @return int 数据库：MapToDo
	 */
	// 删除数据库中的待办件
	public int deleteMapToDo(String uuid);

}
