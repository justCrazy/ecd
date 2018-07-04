package com.ecd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ecd.pojo.MapToDo;

public interface MapToDoService {

	// 将新的待办件添加到数据库中
	public int insertMapToDo(MapToDo mapToDo);

	// 添加待办件时发送邮件
	public void sendMapToDoMessage(String context, String email);

	// 根据查看数据库中的待办件
	public List<MapToDo> selectAllMapToDo(@Param("map2Do_email") String map2Do_email, @Param("page") int page);

	// 根据查看数据库中的待办件数目
	public int selectNumOfMapToDo(String email);

	// 删除数据库中的待办件
	public int deleteMapToDo(String uuid);

}
