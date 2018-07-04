package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecd.dao.MapToDoDao;
import com.ecd.pojo.MapToDo;

public class MapToDoTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void test() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		MapToDoDao mapToDoDao= (MapToDoDao) applicationContext.getBean("mapToDoDao");
		int num = 0;
		// 添加测试
		MapToDo mapToDo = new MapToDo();
		mapToDo.setMap2Do_event_id("8de5248b501311e8ad73c4346b4b53dd");
		mapToDo.setMap2Do_event_description("天然气泄漏");
		mapToDo.setMap2Do_email("12231233");
		mapToDo.setMap2Do_name("LY123X");
		mapToDo.setMap2Do_event_address("重邮");
		mapToDo.setMap2Do_event_time("2018.5.5");
		num = mapToDoDao.insertMapToDo(mapToDo);
		System.out.println(num);
		//查询单人所有待办件
//		List<MapToDo> mapToDos = mapToDoDao.selectAllMapToDo("12231233", 0);
//		System.out.println(mapToDos);
		//查看待办件数目操作
		num = mapToDoDao.selectNumOfMapToDo("12231233");
//		System.out.println(num);
		//删除待办件
//		num = mapToDoDao.deleteMapToDo("8de5248b501311e8ad73c4346b4b53dd");
//		System.out.println(num);
	}
}
