package com.ecd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecd.dao.MapToDoDao;
import com.ecd.pojo.MapToDo;
import com.ecd.service.MapToDoService;
import com.ecd.tool.MessageSend;

@Service("mapToDoService")
public class MapToDoServiceImpl implements MapToDoService {

	@Autowired
	MapToDoDao mapToDoDao;

	/**
	 * 将新的待办件添加到数据库 返回是否插入成功
	 */
	public int insertMapToDo(MapToDo mapToDo) {
		return mapToDoDao.insertMapToDo(mapToDo);
	}

	/**
	 * 根据查看数据库中的待办件 返回list<MapToDao>
	 */
	public List<MapToDo> selectAllMapToDo(String email, int page) {
		return mapToDoDao.selectAllMapToDo(email, (page - 1) * 5);
	}

	/**
	 * 根据查看数据库中的待办件数目 返回数目
	 */
	public int selectNumOfMapToDo(String email) {
		return mapToDoDao.selectNumOfMapToDo(email);
	}

	/**
	 * 删除数据库中的待办件 返回是否删除成功
	 */
	public int deleteMapToDo(String uuid) {
		return mapToDoDao.deleteMapToDo(uuid);
	}

	/**
	 * 发送待办件添加成功信息
	 */
	public void sendMapToDoMessage(String context, String email) {

		try {
			MessageSend.sendMessage(context, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
